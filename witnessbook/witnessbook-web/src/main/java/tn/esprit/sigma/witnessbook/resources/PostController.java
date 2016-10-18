package tn.esprit.sigma.witnessbook.resources;

import tn.esprit.sigma.witnessbook.entities.Post;
import tn.esprit.sigma.witnessbook.service.PostService;
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


@Path("/post")

public class PostController {


    @Inject
    private PostService postService;

   
    @POST
    public Response createPost(Post post) throws URISyntaxException {
        postService.create(post);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/post/" + post.getId())),
                "post", post.getId().toString())
                .entity(post).build();
    }

    
    @PUT
    public Response updatePost(Post post) throws URISyntaxException {
        postService.edit(post);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "post", post.getId().toString())
                .entity(post).build();
    }

    
    @GET
    public List<Post> getAllPosts() {
        List<Post> posts = postService.findAll();
        return posts;
    }

   
    @Path("/{id}")
    @GET
    public Response getPost(@PathParam("id") Integer id) {
        Post post = postService.find(id);
        return Optional.ofNullable(post)
                .map(result -> Response.status(Response.Status.OK).entity(post).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

   
    @Path("/{id}")
    @DELETE
    public Response removePost(@PathParam("id") Integer id) {
        postService.remove(postService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "post", id.toString()).build();
    }

}
