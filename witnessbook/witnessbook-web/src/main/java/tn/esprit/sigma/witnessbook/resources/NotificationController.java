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

import tn.esprit.sigma.witnessbook.entities.Notification;
import tn.esprit.sigma.witnessbook.resources.util.HeaderUtil;
import tn.esprit.sigma.witnessbook.service.NotificationService;


@Path("/notification")

public class NotificationController {


    @EJB
    private NotificationService notificationService;

    
    @POST
    public Response createNotification(Notification notification) throws URISyntaxException {
        notificationService.create(notification);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/notification/" + notification.getId())),
                "notification", notification.getId().toString())
                .entity(notification).build();
    }

    
    @PUT
    public Response updateNotification(Notification notification) throws URISyntaxException {
        notificationService.edit(notification);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "notification", notification.getId().toString())
                .entity(notification).build();
    }

    
    @GET
    public List<Notification> getAllNotifications() {
        List<Notification> notifications = notificationService.findAll();
        return notifications;
    }

   
    @Path("/{id}")
    @GET
    public Response getNotification(@PathParam("id") Integer id) {
        Notification notification = notificationService.find(id);
        return Optional.ofNullable(notification)
                .map(result -> Response.status(Response.Status.OK).entity(notification).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @Path("/{id}")
    @DELETE
    public Response removeNotification(@PathParam("id") Integer id) {
        notificationService.remove(notificationService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "notification", id.toString()).build();
    }

}
