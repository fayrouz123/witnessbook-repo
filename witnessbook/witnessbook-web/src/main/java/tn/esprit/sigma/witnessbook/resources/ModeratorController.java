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


@Path("/moderator")

public class ModeratorController {


    @Inject
    private ModeratorService moderatorService;

   
    @POST
    public Response createModerator(Moderator moderator) throws URISyntaxException {
        moderatorService.create(moderator);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/moderator/" + moderator.getId())),
                "moderator", moderator.getId().toString())
                .entity(moderator).build();
    }

       @PUT
    public Response updateModerator(Moderator moderator) throws URISyntaxException {
        moderatorService.edit(moderator);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "moderator", moderator.getId().toString())
                .entity(moderator).build();
    }

    
    @GET
    public List<Moderator> getAllModerators() {
        List<Moderator> moderators = moderatorService.findAll();
        return moderators;
    }

    
    @Path("/{id}")
    @GET
    public Response getModerator(@PathParam("id") Integer id) {
        Moderator moderator = moderatorService.find(id);
        return Optional.ofNullable(moderator)
                .map(result -> Response.status(Response.Status.OK).entity(moderator).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

   
    @Path("/{id}")
    @DELETE
    public Response removeModerator(@PathParam("id") Integer id) {
        moderatorService.remove(moderatorService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "moderator", id.toString()).build();
    }

}
