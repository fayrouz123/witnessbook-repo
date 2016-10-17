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

/**
 * REST controller for managing Post.
 */
@Path("/api/post")

public class PostController {


    @Inject
    private PostService postService;

    /**
     * POST : Create a new post.
     *
     * @param post the post to create
     * @return the Response with status 201 (Created) and with body the new
     * post, or with status 400 (Bad Request) if the post has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @POST
    public Response createPost(Post post) throws URISyntaxException {
        postService.create(post);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/post/" + post.getId())),
                "post", post.getId().toString())
                .entity(post).build();
    }

    /**
     * PUT : Updates an existing post.
     *
     * @param post the post to update
     * @return the Response with status 200 (OK) and with body the updated post,
     * or with status 400 (Bad Request) if the post is not valid, or with status
     * 500 (Internal Server Error) if the post couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PUT
    public Response updatePost(Post post) throws URISyntaxException {
        postService.edit(post);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "post", post.getId().toString())
                .entity(post).build();
    }

    /**
     * GET : get all the posts. <% if (pagination != 'no') {} @param pageable
     * the p
     *
     * agination information<% } if (fieldsContainNoOwnerOneToOne) {} @param
     * filter the filter of the r
     * equest<% }}
     * @return the Response with status 200 (OK) and the list of posts in body<%
     * if (pagination != 'no') {} @throws URISyntaxExce
     * ption if there is an error to generate the pagination HTTP headers<% }}
     */
    @GET
    public List<Post> getAllPosts() {
        List<Post> posts = postService.findAll();
        return posts;
    }

    /**
     * GET /:id : get the "id" post.
     *
     * @param id the id of the post to retrieve
     * @return the Response with status 200 (OK) and with body the post, or with
     * status 404 (Not Found)
     */
    @Path("/{id}")
    @GET
    public Response getPost(@PathParam("id") Integer id) {
        Post post = postService.find(id);
        return Optional.ofNullable(post)
                .map(result -> Response.status(Response.Status.OK).entity(post).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * DELETE /:id : remove the "id" post.
     *
     * @param id the id of the post to delete
     * @return the Response with status 200 (OK)
     */
    @Path("/{id}")
    @DELETE
    public Response removePost(@PathParam("id") Integer id) {
        postService.remove(postService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "post", id.toString()).build();
    }

}
