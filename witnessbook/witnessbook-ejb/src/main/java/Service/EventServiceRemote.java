package Service;

import java.util.List;

import javax.ejb.Remote;

import entities.Event;
@Remote
public interface EventServiceRemote {
	void addEvent(Event event);

	void updateEvent(Event event);

	void deleteEventById(Integer idEvent);

	void deleteEvent(Event event);

	Event findEventById(Integer idEvent);

	List<Event> findAllEvents();

}
