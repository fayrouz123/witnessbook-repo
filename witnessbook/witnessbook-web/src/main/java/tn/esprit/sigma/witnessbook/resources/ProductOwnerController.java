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

import tn.esprit.sigma.witnessbook.entities.ProductOwner;
import tn.esprit.sigma.witnessbook.resources.util.HeaderUtil;
import tn.esprit.sigma.witnessbook.service.ProductOwnerService;


@Path("/product-owner")

public class ProductOwnerController {


    @EJB
    private ProductOwnerService productOwnerService;

    
    @POST
    public Response createProductOwner(ProductOwner productOwner) throws URISyntaxException {
        productOwnerService.create(productOwner);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/product-owner/" + productOwner.getId())),
                "productOwner", productOwner.getId().toString())
                .entity(productOwner).build();
    }

   
    @PUT
    public Response updateProductOwner(ProductOwner productOwner) throws URISyntaxException {
        productOwnerService.edit(productOwner);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "productOwner", productOwner.getId().toString())
                .entity(productOwner).build();
    }

   
    @GET
    public List<ProductOwner> getAllProductOwners() {
        List<ProductOwner> productOwners = productOwnerService.findAll();
        return productOwners;
    }

    
    @Path("/{id}")
    @GET
    public Response getProductOwner(@PathParam("id") Integer id) {
        ProductOwner productOwner = productOwnerService.find(id);
        return Optional.ofNullable(productOwner)
                .map(result -> Response.status(Response.Status.OK).entity(productOwner).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

  
    @Path("/{id}")
    @DELETE
    public Response removeProductOwner(@PathParam("id") Integer id) {
        productOwnerService.remove(productOwnerService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "productOwner", id.toString()).build();
    }

}
