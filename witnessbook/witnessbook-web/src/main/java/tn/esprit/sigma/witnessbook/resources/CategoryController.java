package tn.esprit.sigma.witnessbook.resources;

import tn.esprit.sigma.witnessbook.entities.Category;
import tn.esprit.sigma.witnessbook.service.CategoryService;
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


@Path("/category")

public class CategoryController {


    @Inject
    private CategoryService categoryService;

   
    @POST
    public Response createCategory(Category category) throws URISyntaxException {
        categoryService.create(category);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/category/" + category.getId())),
                "category", category.getId().toString())
                .entity(category).build();
    }

    
    @PUT
    public Response updateCategory(Category category) throws URISyntaxException {
        categoryService.edit(category);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "category", category.getId().toString())
                .entity(category).build();
    }

 
    @GET
    public List<Category> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        return categories;
    }

   
    @Path("/{id}")
    @GET
    public Response getCategory(@PathParam("id") Integer id) {
        Category category = categoryService.find(id);
        return Optional.ofNullable(category)
                .map(result -> Response.status(Response.Status.OK).entity(category).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    
    @Path("/{id}")
    @DELETE
    public Response removeCategory(@PathParam("id") Integer id) {
        categoryService.remove(categoryService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "category", id.toString()).build();
    }

}
