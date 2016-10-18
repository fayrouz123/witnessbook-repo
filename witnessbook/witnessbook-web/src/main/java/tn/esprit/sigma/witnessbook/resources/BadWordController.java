package tn.esprit.sigma.witnessbook.resources;

import tn.esprit.sigma.witnessbook.entities.BadWord;
import tn.esprit.sigma.witnessbook.service.BadWordService;
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
 * REST controller for managing BadWord.
 */
@Path("/bad-word")
public class BadWordController {


    @Inject
    private BadWordService badWordService;

    /**
     * POST : Create a new badWord.
     *
     * @param badWord the badWord to create
     * @return the Response with status 201 (Created) and with body the new
     * badWord, or with status 400 (Bad Request) if the badWord has already an
     * ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @POST
    public Response createBadWord(BadWord badWord) throws URISyntaxException {
        badWordService.create(badWord);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/bad-word/" + badWord.getId())),
                "badWord", badWord.getId().toString())
                .entity(badWord).build();
    }

    /**
     * PUT : Updates an existing badWord.
     *
     * @param badWord the badWord to update
     * @return the Response with status 200 (OK) and with body the updated
     * badWord, or with status 400 (Bad Request) if the badWord is not valid, or
     * with status 500 (Internal Server Error) if the badWord couldn't be
     * updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PUT
    public Response updateBadWord(BadWord badWord) throws URISyntaxException {
        badWordService.edit(badWord);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "badWord", badWord.getId().toString())
                .entity(badWord).build();
    }

    /**
     * GET : get all the badWords. <% if (pagination != 'no') {} @param pageable
     * the p
     *
     * agination information<% } if (fieldsContainNoOwnerOneToOne) {} @param
     * filter the filter of the r
     * equest<% }}
     * @return the Response with status 200 (OK) and the list of badWords in
     * body<% if (pagination != 'no') {} @throws URISyntaxExce
     * ption if there is an error to generate the pagination HTTP headers<% }}
     */
    @GET
    public List<BadWord> getAllBadWords() {
        List<BadWord> badWords = badWordService.findAll();
        return badWords;
    }

    /**
     * GET /:id : get the "id" badWord.
     *
     * @param id the id of the badWord to retrieve
     * @return the Response with status 200 (OK) and with body the badWord, or
     * with status 404 (Not Found)
     */
    @Path("/{id}")
    @GET
    public Response getBadWord(@PathParam("id") Integer id) {
        BadWord badWord = badWordService.find(id);
        return Optional.ofNullable(badWord)
                .map(result -> Response.status(Response.Status.OK).entity(badWord).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * DELETE /:id : remove the "id" badWord.
     *
     * @param id the id of the badWord to delete
     * @return the Response with status 200 (OK)
     */
    @Path("/{id}")
    @DELETE
    public Response removeBadWord(@PathParam("id") Integer id) {
        badWordService.remove(badWordService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "badWord", id.toString()).build();
    }

}
