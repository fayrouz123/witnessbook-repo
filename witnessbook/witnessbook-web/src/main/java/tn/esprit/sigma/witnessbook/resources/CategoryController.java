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

/**
 * REST controller for managing Category.
 */
@Path("/category")

public class CategoryController {


    @Inject
    private CategoryService categoryService;

    /**
     * POST : Create a new category.
     *
     * @param category the category to create
     * @return the Response with status 201 (Created) and with body the new
     * category, or with status 400 (Bad Request) if the category has already an
     * ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @POST
    public Response createCategory(Category category) throws URISyntaxException {
        categoryService.create(category);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/category/" + category.getId())),
                "category", category.getId().toString())
                .entity(category).build();
    }

    /**
     * PUT : Updates an existing category.
     *
     * @param category the category to update
     * @return the Response with status 200 (OK) and with body the updated
     * category, or with status 400 (Bad Request) if the category is not valid,
     * or with status 500 (Internal Server Error) if the category couldn't be
     * updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PUT
    public Response updateCategory(Category category) throws URISyntaxException {
        categoryService.edit(category);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "category", category.getId().toString())
                .entity(category).build();
    }

    /**
     * GET : get all the categories. <% if (pagination != 'no') {} @param
     * pageable the p
     *
     * agination information<% } if (fieldsContainNoOwnerOneToOne) {} @param
     * filter the filter of the r
     * equest<% }}
     * @return the Response with status 200 (OK) and the list of categories in
     * body<% if (pagination != 'no') {} @throws URISyntaxExce
     * ption if there is an error to generate the pagination HTTP headers<% }}
     */
    @GET
    public List<Category> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        return categories;
    }

    /**
     * GET /:id : get the "id" category.
     *
     * @param id the id of the category to retrieve
     * @return the Response with status 200 (OK) and with body the category, or
     * with status 404 (Not Found)
     */
    @Path("/{id}")
    @GET
    public Response getCategory(@PathParam("id") Integer id) {
        Category category = categoryService.find(id);
        return Optional.ofNullable(category)
                .map(result -> Response.status(Response.Status.OK).entity(category).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * DELETE /:id : remove the "id" category.
     *
     * @param id the id of the category to delete
     * @return the Response with status 200 (OK)
     */
    @Path("/{id}")
    @DELETE
    public Response removeCategory(@PathParam("id") Integer id) {
        categoryService.remove(categoryService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "category", id.toString()).build();
    }

}
