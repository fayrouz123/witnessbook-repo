package tn.esprit.sigma.witnessbook.resources;

import tn.esprit.sigma.witnessbook.entities.Moderator;
import tn.esprit.sigma.witnessbook.service.ModeratorService;
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

/**
 * REST controller for managing Moderator.
 */
@Path("/moderator")

public class ModeratorController {


    @Inject
    private ModeratorService moderatorService;

    /**
     * POST : Create a new moderator.
     *
     * @param moderator the moderator to create
     * @return the Response with status 201 (Created) and with body the new
     * moderator, or with status 400 (Bad Request) if the moderator has already
     * an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @POST
    public Response createModerator(Moderator moderator) throws URISyntaxException {
        moderatorService.create(moderator);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/moderator/" + moderator.getId())),
                "moderator", moderator.getId().toString())
                .entity(moderator).build();
    }

    /**
     * PUT : Updates an existing moderator.
     *
     * @param moderator the moderator to update
     * @return the Response with status 200 (OK) and with body the updated
     * moderator, or with status 400 (Bad Request) if the moderator is not
     * valid, or with status 500 (Internal Server Error) if the moderator
     * couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PUT
    public Response updateModerator(Moderator moderator) throws URISyntaxException {
        moderatorService.edit(moderator);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "moderator", moderator.getId().toString())
                .entity(moderator).build();
    }

    /**
     * GET : get all the moderators. <% if (pagination != 'no') {} @param
     * pageable the p
     *
     * agination information<% } if (fieldsContainNoOwnerOneToOne) {} @param
     * filter the filter of the r
     * equest<% }}
     * @return the Response with status 200 (OK) and the list of moderators in
     * body<% if (pagination != 'no') {} @throws URISyntaxExce
     * ption if there is an error to generate the pagination HTTP headers<% }}
     */
    @GET
    public List<Moderator> getAllModerators() {
        List<Moderator> moderators = moderatorService.findAll();
        return moderators;
    }

    /**
     * GET /:id : get the "id" moderator.
     *
     * @param id the id of the moderator to retrieve
     * @return the Response with status 200 (OK) and with body the moderator, or
     * with status 404 (Not Found)
     */
    @Path("/{id}")
    @GET
    public Response getModerator(@PathParam("id") Integer id) {
        Moderator moderator = moderatorService.find(id);
        return Optional.ofNullable(moderator)
                .map(result -> Response.status(Response.Status.OK).entity(moderator).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * DELETE /:id : remove the "id" moderator.
     *
     * @param id the id of the moderator to delete
     * @return the Response with status 200 (OK)
     */
    @Path("/{id}")
    @DELETE
    public Response removeModerator(@PathParam("id") Integer id) {
        moderatorService.remove(moderatorService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "moderator", id.toString()).build();
    }

}
