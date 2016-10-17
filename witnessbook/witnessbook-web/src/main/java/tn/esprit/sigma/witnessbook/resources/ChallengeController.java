package tn.esprit.sigma.witnessbook.resources;

import tn.esprit.sigma.witnessbook.entities.Challenge;
import tn.esprit.sigma.witnessbook.service.ChallengeService;
import tn.esprit.sigma.witnessbook.resources.util.HeaderUtil;
import tn.esprit.sigma.witnessbook.security.Secured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * REST controller for managing Challenge.
 */
@Path("/api/challenge")
@Secured
public class ChallengeController {

    private final Logger log = LoggerFactory.getLogger(ChallengeController.class);

    @Inject
    private ChallengeService challengeService;

    /**
     * POST : Create a new challenge.
     *
     * @param challenge the challenge to create
     * @return the Response with status 201 (Created) and with body the new
     * challenge, or with status 400 (Bad Request) if the challenge has already
     * an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @POST
    public Response createChallenge(Challenge challenge) throws URISyntaxException {
        log.debug("REST request to save Challenge : {}", challenge);
        challengeService.create(challenge);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/challenge/" + challenge.getId())),
                "challenge", challenge.getId().toString())
                .entity(challenge).build();
    }

    /**
     * PUT : Updates an existing challenge.
     *
     * @param challenge the challenge to update
     * @return the Response with status 200 (OK) and with body the updated
     * challenge, or with status 400 (Bad Request) if the challenge is not
     * valid, or with status 500 (Internal Server Error) if the challenge
     * couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PUT
    public Response updateChallenge(Challenge challenge) throws URISyntaxException {
        log.debug("REST request to update Challenge : {}", challenge);
        challengeService.edit(challenge);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "challenge", challenge.getId().toString())
                .entity(challenge).build();
    }

    /**
     * GET : get all the challenges. <% if (pagination != 'no') {} @param
     * pageable the p
     *
     * agination information<% } if (fieldsContainNoOwnerOneToOne) {} @param
     * filter the filter of the r
     * equest<% }}
     * @return the Response with status 200 (OK) and the list of challenges in
     * body<% if (pagination != 'no') {} @throws URISyntaxExce
     * ption if there is an error to generate the pagination HTTP headers<% }}
     */
    @GET
    public List<Challenge> getAllChallenges() {
        log.debug("REST request to get all Challenges");
        List<Challenge> challenges = challengeService.findAll();
        return challenges;
    }

    /**
     * GET /:id : get the "id" challenge.
     *
     * @param id the id of the challenge to retrieve
     * @return the Response with status 200 (OK) and with body the challenge, or
     * with status 404 (Not Found)
     */
    @Path("/{id}")
    @GET
    public Response getChallenge(@PathParam("id") Integer id) {
        log.debug("REST request to get Challenge : {}", id);
        Challenge challenge = challengeService.find(id);
        return Optional.ofNullable(challenge)
                .map(result -> Response.status(Response.Status.OK).entity(challenge).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * DELETE /:id : remove the "id" challenge.
     *
     * @param id the id of the challenge to delete
     * @return the Response with status 200 (OK)
     */
    @Path("/{id}")
    @DELETE
    public Response removeChallenge(@PathParam("id") Integer id) {
        log.debug("REST request to delete Challenge : {}", id);
        challengeService.remove(challengeService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "challenge", id.toString()).build();
    }

}
