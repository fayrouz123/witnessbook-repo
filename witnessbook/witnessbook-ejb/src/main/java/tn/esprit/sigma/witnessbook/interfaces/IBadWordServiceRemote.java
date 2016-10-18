package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.sigma.witnessbook.entities.BadWord;

@Remote
public interface IBadWordServiceRemote {

	void create(BadWord entity);

	BadWord edit(BadWord entity);

	void remove(BadWord entity);

	BadWord find(Object id);

	List<BadWord> findAll();

	List<BadWord> findRange(int startPosition, int size);

	int count();
}
