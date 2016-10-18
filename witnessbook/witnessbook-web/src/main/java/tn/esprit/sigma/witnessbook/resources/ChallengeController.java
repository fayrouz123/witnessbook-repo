package tn.esprit.sigma.witnessbook.resources;

import tn.esprit.sigma.witnessbook.entities.Challenge;
import tn.esprit.sigma.witnessbook.service.ChallengeService;
import tn.esprit.sigma.witnessbook.resources.util.HeaderUtil;
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


@Path("/challenge")
public class ChallengeController {


    @Inject
    private ChallengeService challengeService;

   
    @POST
    public Response createChallenge(Challenge challenge) throws URISyntaxException {
        challengeService.create(challenge);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/challenge/" + challenge.getId())),
                "challenge", challenge.getId().toString())
                .entity(challenge).build();
    }

   
    @PUT
    public Response updateChallenge(Challenge challenge) throws URISyntaxException {
        challengeService.edit(challenge);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "challenge", challenge.getId().toString())
                .entity(challenge).build();
    }

   
    @GET
    public List<Challenge> getAllChallenges() {
        List<Challenge> challenges = challengeService.findAll();
        return challenges;
    }

    
    @Path("/{id}")
    @GET
    public Response getChallenge(@PathParam("id") Integer id) {
        Challenge challenge = challengeService.find(id);
        return Optional.ofNullable(challenge)
                .map(result -> Response.status(Response.Status.OK).entity(challenge).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

   
    @Path("/{id}")
    @DELETE
    public Response removeChallenge(@PathParam("id") Integer id) {
        challengeService.remove(challengeService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "challenge", id.toString()).build();
    }

}
