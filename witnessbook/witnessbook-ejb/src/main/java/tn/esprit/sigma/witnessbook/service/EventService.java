package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.sigma.witnessbook.entities.Event;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless
@Named("event")
public class EventService extends AbstractService<Event> {
	@PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventService() {
        super(Event.class);
    }

}
