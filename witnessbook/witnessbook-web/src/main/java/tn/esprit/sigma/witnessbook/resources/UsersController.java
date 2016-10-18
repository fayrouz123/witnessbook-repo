package tn.esprit.sigma.witnessbook.resources;

import tn.esprit.sigma.witnessbook.entities.Users;
import tn.esprit.sigma.witnessbook.service.UsersService;
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


@Path("/users")
public class UsersController {


    @Inject
    private UsersService usersService;

   
    @POST
    public Response createUsers(Users users) throws URISyntaxException {
        usersService.create(users);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/users/" + users.getId())),
                "users", users.getId().toString())
                .entity(users).build();
    }

    
    @PUT
    public Response updateUsers(Users users) throws URISyntaxException {
        usersService.edit(users);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "users", users.getId().toString())
                .entity(users).build();
    }

    
    @GET
    public List<Users> getAllUserss() {
        List<Users> userss = usersService.findAll();
        return userss;
    }

   
    @Path("/{id}")
    @GET
    public Response getUsers(@PathParam("id") Integer id) {
        Users users = usersService.find(id);
        return Optional.ofNullable(users)
                .map(result -> Response.status(Response.Status.OK).entity(users).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

   
    @Path("/{id}")
    @DELETE
    public Response removeUsers(@PathParam("id") Integer id) {
        usersService.remove(usersService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "users", id.toString()).build();
    }

}
