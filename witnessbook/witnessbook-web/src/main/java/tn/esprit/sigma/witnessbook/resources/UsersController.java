package tn.esprit.sigma.witnessbook.resources;

import tn.esprit.sigma.witnessbook.entities.Users;
import tn.esprit.sigma.witnessbook.service.UsersService;
import tn.esprit.sigma.witnessbook.resources.util.HeaderUtil;
import tn.esprit.sigma.witnessbook.security.Secured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * REST controller for managing Users.
 */
@Path("/api/users")
@Secured
public class UsersController {

    private final Logger log = LoggerFactory.getLogger(UsersController.class);

    @Inject
    private UsersService usersService;

    /**
     * POST : Create a new users.
     *
     * @param users the users to create
     * @return the Response with status 201 (Created) and with body the new
     * users, or with status 400 (Bad Request) if the users has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @POST
    public Response createUsers(Users users) throws URISyntaxException {
        log.debug("REST request to save Users : {}", users);
        usersService.create(users);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/users/" + users.getId())),
                "users", users.getId().toString())
                .entity(users).build();
    }

    /**
     * PUT : Updates an existing users.
     *
     * @param users the users to update
     * @return the Response with status 200 (OK) and with body the updated
     * users, or with status 400 (Bad Request) if the users is not valid, or
     * with status 500 (Internal Server Error) if the users couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PUT
    public Response updateUsers(Users users) throws URISyntaxException {
        log.debug("REST request to update Users : {}", users);
        usersService.edit(users);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "users", users.getId().toString())
                .entity(users).build();
    }

    /**
     * GET : get all the userss. <% if (pagination != 'no') {} @param pageable
     * the p
     *
     * agination information<% } if (fieldsContainNoOwnerOneToOne) {} @param
     * filter the filter of the r
     * equest<% }}
     * @return the Response with status 200 (OK) and the list of userss in
     * body<% if (pagination != 'no') {} @throws URISyntaxExce
     * ption if there is an error to generate the pagination HTTP headers<% }}
     */
    @GET
    public List<Users> getAllUserss() {
        log.debug("REST request to get all Userss");
        List<Users> userss = usersService.findAll();
        return userss;
    }

    /**
     * GET /:id : get the "id" users.
     *
     * @param id the id of the users to retrieve
     * @return the Response with status 200 (OK) and with body the users, or
     * with status 404 (Not Found)
     */
    @Path("/{id}")
    @GET
    public Response getUsers(@PathParam("id") Integer id) {
        log.debug("REST request to get Users : {}", id);
        Users users = usersService.find(id);
        return Optional.ofNullable(users)
                .map(result -> Response.status(Response.Status.OK).entity(users).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * DELETE /:id : remove the "id" users.
     *
     * @param id the id of the users to delete
     * @return the Response with status 200 (OK)
     */
    @Path("/{id}")
    @DELETE
    public Response removeUsers(@PathParam("id") Integer id) {
        log.debug("REST request to delete Users : {}", id);
        usersService.remove(usersService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "users", id.toString()).build();
    }

}
