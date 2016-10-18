package tn.esprit.sigma.witnessbook.resources;

import tn.esprit.sigma.witnessbook.entities.Witness;
import tn.esprit.sigma.witnessbook.service.WitnessService;
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
 * REST controller for managing Witness.
 */
@Path("/witness")
public class WitnessController {


    @Inject
    private WitnessService witnessService;

    /**
     * POST : Create a new witness.
     *
     * @param witness the witness to create
     * @return the Response with status 201 (Created) and with body the new
     * witness, or with status 400 (Bad Request) if the witness has already an
     * ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @POST
    public Response createWitness(Witness witness) throws URISyntaxException {
        witnessService.create(witness);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/witness/" + witness.getId())),
                "witness", witness.getId().toString())
                .entity(witness).build();
    }

    /**
     * PUT : Updates an existing witness.
     *
     * @param witness the witness to update
     * @return the Response with status 200 (OK) and with body the updated
     * witness, or with status 400 (Bad Request) if the witness is not valid, or
     * with status 500 (Internal Server Error) if the witness couldn't be
     * updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PUT
    public Response updateWitness(Witness witness) throws URISyntaxException {
        witnessService.edit(witness);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "witness", witness.getId().toString())
                .entity(witness).build();
    }

    /**
     * GET : get all the witnesses. <% if (pagination != 'no') {} @param
     * pageable the p
     *
     * agination information<% } if (fieldsContainNoOwnerOneToOne) {} @param
     * filter the filter of the r
     * equest<% }}
     * @return the Response with status 200 (OK) and the list of witnesses in
     * body<% if (pagination != 'no') {} @throws URISyntaxExce
     * ption if there is an error to generate the pagination HTTP headers<% }}
     */
    @GET
    public List<Witness> getAllWitnesses() {
        List<Witness> witnesses = witnessService.findAll();
        return witnesses;
    }

    /**
     * GET /:id : get the "id" witness.
     *
     * @param id the id of the witness to retrieve
     * @return the Response with status 200 (OK) and with body the witness, or
     * with status 404 (Not Found)
     */
    @Path("/{id}")
    @GET
    public Response getWitness(@PathParam("id") Integer id) {
        Witness witness = witnessService.find(id);
        return Optional.ofNullable(witness)
                .map(result -> Response.status(Response.Status.OK).entity(witness).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * DELETE /:id : remove the "id" witness.
     *
     * @param id the id of the witness to delete
     * @return the Response with status 200 (OK)
     */
    @Path("/{id}")
    @DELETE
    public Response removeWitness(@PathParam("id") Integer id) {
        witnessService.remove(witnessService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "witness", id.toString()).build();
    }

}
