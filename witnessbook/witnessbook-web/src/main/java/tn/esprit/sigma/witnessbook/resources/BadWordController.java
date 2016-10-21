package tn.esprit.sigma.witnessbook.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import tn.esprit.sigma.witnessbook.entities.BadWord;
import tn.esprit.sigma.witnessbook.resources.util.HeaderUtil;
import tn.esprit.sigma.witnessbook.service.BadWordService;


@Path("/bad-word")
public class BadWordController {


    @EJB
    private BadWordService badWordService;

 
    @POST
    public Response createBadWord(BadWord badWord) throws URISyntaxException {
        badWordService.create(badWord);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/bad-word/" + badWord.getId())),
                "badWord", badWord.getId().toString())
                .entity(badWord).build();
    }

  
    @PUT
    public Response updateBadWord(BadWord badWord) throws URISyntaxException {
        badWordService.edit(badWord);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "badWord", badWord.getId().toString())
                .entity(badWord).build();
    }

   
    @GET
    public List<BadWord> getAllBadWords() {
        List<BadWord> badWords = badWordService.findAll();
        return badWords;
    }


    @Path("/{id}")
    @GET
    public Response getBadWord(@PathParam("id") Integer id) {
        BadWord badWord = badWordService.find(id);
        return Optional.ofNullable(badWord)
                .map(result -> Response.status(Response.Status.OK).entity(badWord).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

   
    @Path("/{id}")
    @DELETE
    public Response removeBadWord(@PathParam("id") Integer id) {
        badWordService.remove(badWordService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "badWord", id.toString()).build();
    }

}
