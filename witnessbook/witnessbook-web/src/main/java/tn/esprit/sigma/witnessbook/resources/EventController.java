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

import tn.esprit.sigma.witnessbook.entities.Event;
import tn.esprit.sigma.witnessbook.resources.util.HeaderUtil;
import tn.esprit.sigma.witnessbook.service.EventService;


@Path("/event")
public class EventController {


    @EJB
    private EventService eventService;

   
    @POST
    public Response createEvent(Event event) throws URISyntaxException {
        eventService.create(event);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/event/" + event.getId())),
                "event", event.getId().toString())
                .entity(event).build();
    }

    
    @PUT
    public Response updateEvent(Event event) throws URISyntaxException {
        eventService.edit(event);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "event", event.getId().toString())
                .entity(event).build();
    }

   
    @GET
    public List<Event> getAllEvents() {
        List<Event> events = eventService.findAll();
        return events;
    }

   
    @Path("/{id}")
    @GET
    public Response getEvent(@PathParam("id") Integer id) {
        Event event = eventService.find(id);
        return Optional.ofNullable(event)
                .map(result -> Response.status(Response.Status.OK).entity(event).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    
    @Path("/{id}")
    @DELETE
    public Response removeEvent(@PathParam("id") Integer id) {
        eventService.remove(eventService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "event", id.toString()).build();
    }

}
