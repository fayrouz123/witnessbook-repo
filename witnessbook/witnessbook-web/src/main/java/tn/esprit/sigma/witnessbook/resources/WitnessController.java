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

import tn.esprit.sigma.witnessbook.entities.Witness;
import tn.esprit.sigma.witnessbook.resources.util.HeaderUtil;
import tn.esprit.sigma.witnessbook.service.WitnessService;


@Path("/witness")
public class WitnessController {


    @EJB
    private WitnessService witnessService;

   
    @POST
    public Response createWitness(Witness witness) throws URISyntaxException {
        witnessService.create(witness);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/witness/" + witness.getId())),
                "witness", witness.getId().toString())
                .entity(witness).build();
    }

   
    @PUT
    public Response updateWitness(Witness witness) throws URISyntaxException {
        witnessService.edit(witness);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "witness", witness.getId().toString())
                .entity(witness).build();
    }

   
    @GET
    public List<Witness> getAllWitnesses() {
        List<Witness> witnesses = witnessService.findAll();
        return witnesses;
    }

    
    @Path("/{id}")
    @GET
    public Response getWitness(@PathParam("id") Integer id) {
        Witness witness = witnessService.find(id);
        return Optional.ofNullable(witness)
                .map(result -> Response.status(Response.Status.OK).entity(witness).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @Path("/{id}")
    @DELETE
    public Response removeWitness(@PathParam("id") Integer id) {
        witnessService.remove(witnessService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "witness", id.toString()).build();
    }

}
