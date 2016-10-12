package Service;

import java.util.List;

import javax.ejb.Local;

import entities.Event;
@Local
public interface EventServiceLocal {

	void addEvent(Event event);

	void updateEvent(Event event);

	void deleteEventById(Integer idEvent);

	void deleteEvent(Event event);

	Event findEventById(Integer idEvent);

	List<Event> findAllEvents();
}
