package tn.esprit.sigma.witnessbook.service;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.sigma.witnessbook.entities.WitnessCard;

@Remote
public interface WitnessCardServiceRemote {
	void create(WitnessCard entity);

	WitnessCard edit(WitnessCard entity);

	void remove(WitnessCard entity);

	WitnessCard find(Object id);

	List<WitnessCard> findAll();

	List<WitnessCard> findRange(int startPosition, int size);

	int count();
}
