package Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Event;

public class EventService implements EventServiceLocal, EventServiceRemote {
	@PersistenceContext

	EntityManager em;

	@Override
	public void addEvent(Event event) {
		// TODO Auto-generated method stub
		em.persist(event);
	}

	@Override
	public void updateEvent(Event event) {
		// TODO Auto-generated method stub
		em.merge(event);
	}

	@Override
	public void deleteEventById(Integer idEvent) {
		// TODO Auto-generated method stub
		em.remove(findEventById(idEvent));
	}

	@Override
	public void deleteEvent(Event event) {
		// TODO Auto-generated method stub
		em.remove(event);
	}

	@Override
	public Event findEventById(Integer idEvent) {
		// TODO Auto-generated method stub
		return em.find(Event.class, idEvent);
	}

	@Override
	public List<Event> findAllEvents() {
		// TODO Auto-generated method stub
		String jpql = "SELECT u FROM Event u";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
