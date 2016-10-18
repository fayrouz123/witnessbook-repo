package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.sigma.witnessbook.entities.Event;

@Local
public interface IEventServiceLocal {
	void create(Event entity);

	Event edit(Event entity);

	void remove(Event entity);

	Event find(Object id);

	List<Event> findAll();

	List<Event> findRange(int startPosition, int size);

	int count();
}
