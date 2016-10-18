package tn.esprit.sigma.witnessbook.resources;

import tn.esprit.sigma.witnessbook.entities.WitnessCard;
import tn.esprit.sigma.witnessbook.service.WitnessCardService;
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
 * REST controller for managing WitnessCard.
 */
@Path("/witness-card")
public class WitnessCardController {


    @Inject
    private WitnessCardService witnessCardService;

    /**
     * POST : Create a new witnessCard.
     *
     * @param witnessCard the witnessCard to create
     * @return the Response with status 201 (Created) and with body the new
     * witnessCard, or with status 400 (Bad Request) if the witnessCard has
     * already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @POST
    public Response createWitnessCard(WitnessCard witnessCard) throws URISyntaxException {
        witnessCardService.create(witnessCard);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/witness-card/" + witnessCard.getId())),
                "witnessCard", witnessCard.getId().toString())
                .entity(witnessCard).build();
    }

    /**
     * PUT : Updates an existing witnessCard.
     *
     * @param witnessCard the witnessCard to update
     * @return the Response with status 200 (OK) and with body the updated
     * witnessCard, or with status 400 (Bad Request) if the witnessCard is not
     * valid, or with status 500 (Internal Server Error) if the witnessCard
     * couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PUT
    public Response updateWitnessCard(WitnessCard witnessCard) throws URISyntaxException {
        witnessCardService.edit(witnessCard);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "witnessCard", witnessCard.getId().toString())
                .entity(witnessCard).build();
    }

    /**
     * GET : get all the witnessCards. <% if (pagination != 'no') {} @param
     * pageable the p
     *
     * agination information<% } if (fieldsContainNoOwnerOneToOne) {} @param
     * filter the filter of the r
     * equest<% }}
     * @return the Response with status 200 (OK) and the list of witnessCards in
     * body<% if (pagination != 'no') {} @throws URISyntaxExce
     * ption if there is an error to generate the pagination HTTP headers<% }}
     */
    @GET
    public List<WitnessCard> getAllWitnessCards() {
        List<WitnessCard> witnessCards = witnessCardService.findAll();
        return witnessCards;
    }

    /**
     * GET /:id : get the "id" witnessCard.
     *
     * @param id the id of the witnessCard to retrieve
     * @return the Response with status 200 (OK) and with body the witnessCard,
     * or with status 404 (Not Found)
     */
    @Path("/{id}")
    @GET
    public Response getWitnessCard(@PathParam("id") Integer id) {
        WitnessCard witnessCard = witnessCardService.find(id);
        return Optional.ofNullable(witnessCard)
                .map(result -> Response.status(Response.Status.OK).entity(witnessCard).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * DELETE /:id : remove the "id" witnessCard.
     *
     * @param id the id of the witnessCard to delete
     * @return the Response with status 200 (OK)
     */
    @Path("/{id}")
    @DELETE
    public Response removeWitnessCard(@PathParam("id") Integer id) {
        witnessCardService.remove(witnessCardService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "witnessCard", id.toString()).build();
    }

}
