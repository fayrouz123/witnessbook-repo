package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.sigma.witnessbook.entities.Witness;

@Remote
public interface IWitnessServiceRemote {

	void create(Witness entity);

	Witness edit(Witness entity);

	void remove(Witness entity);

	Witness find(Object id);

	List<Witness> findAll();

	List<Witness> findRange(int startPosition, int size);

	int count();
}
