package tn.esprit.sigma.witnessbook.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.sigma.witnessbook.entities.Event;
import tn.esprit.sigma.witnessbook.interfaces.IEventServiceLocal;
import tn.esprit.sigma.witnessbook.interfaces.IEventServiceRemote;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless
@Named("event")
public class EventService extends AbstractService<Event> implements IEventServiceLocal,IEventServiceRemote{
	@PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventService() {
        super(Event.class);
    }
    @SuppressWarnings("unchecked")
	@Override
	public List<Event> findAllEventsOrderedByDate() {

		String jpql = "SELECT e FROM Event e ORDER BY e.date";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	@SuppressWarnings("null")
	@Override
	public List<Event> tomorrowUpcomingEvents() {
		Date currentDate = new Date();
		List<Event> allEvents = findAllEventsOrderedByDate();
		List<Event> events = null;
		for (Event event : allEvents) {

			if ((event.getDate().getTime() - currentDate.getTime()) / (60 * 60 * 1000) < 24)
				events.add(event);
		}

		return events;
	}

}
