package tn.esprit.sigma.witnessbook.resources;

import tn.esprit.sigma.witnessbook.entities.ProductOwner;
import tn.esprit.sigma.witnessbook.service.ProductOwnerService;
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
 * REST controller for managing ProductOwner.
 */
@Path("/product-owner")

public class ProductOwnerController {


    @Inject
    private ProductOwnerService productOwnerService;

    /**
     * POST : Create a new productOwner.
     *
     * @param productOwner the productOwner to create
     * @return the Response with status 201 (Created) and with body the new
     * productOwner, or with status 400 (Bad Request) if the productOwner has
     * already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @POST
    public Response createProductOwner(ProductOwner productOwner) throws URISyntaxException {
        productOwnerService.create(productOwner);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/product-owner/" + productOwner.getId())),
                "productOwner", productOwner.getId().toString())
                .entity(productOwner).build();
    }

    /**
     * PUT : Updates an existing productOwner.
     *
     * @param productOwner the productOwner to update
     * @return the Response with status 200 (OK) and with body the updated
     * productOwner, or with status 400 (Bad Request) if the productOwner is not
     * valid, or with status 500 (Internal Server Error) if the productOwner
     * couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PUT
    public Response updateProductOwner(ProductOwner productOwner) throws URISyntaxException {
        productOwnerService.edit(productOwner);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "productOwner", productOwner.getId().toString())
                .entity(productOwner).build();
    }

    /**
     * GET : get all the productOwners. <% if (pagination != 'no') {} @param
     * pageable the p
     *
     * agination information<% } if (fieldsContainNoOwnerOneToOne) {} @param
     * filter the filter of the r
     * equest<% }}
     * @return the Response with status 200 (OK) and the list of productOwners
     * in body<% if (pagination != 'no') {} @throws URISyntaxExce
     * ption if there is an error to generate the pagination HTTP headers<% }}
     */
    @GET
    public List<ProductOwner> getAllProductOwners() {
        List<ProductOwner> productOwners = productOwnerService.findAll();
        return productOwners;
    }

    /**
     * GET /:id : get the "id" productOwner.
     *
     * @param id the id of the productOwner to retrieve
     * @return the Response with status 200 (OK) and with body the productOwner,
     * or with status 404 (Not Found)
     */
    @Path("/{id}")
    @GET
    public Response getProductOwner(@PathParam("id") Integer id) {
        ProductOwner productOwner = productOwnerService.find(id);
        return Optional.ofNullable(productOwner)
                .map(result -> Response.status(Response.Status.OK).entity(productOwner).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * DELETE /:id : remove the "id" productOwner.
     *
     * @param id the id of the productOwner to delete
     * @return the Response with status 200 (OK)
     */
    @Path("/{id}")
    @DELETE
    public Response removeProductOwner(@PathParam("id") Integer id) {
        productOwnerService.remove(productOwnerService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "productOwner", id.toString()).build();
    }

}
