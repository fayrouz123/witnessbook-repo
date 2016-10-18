package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.sigma.witnessbook.entities.Challenge;

@Remote
public interface IChallengeServiceRemote {

	void create(Challenge entity);

	Challenge edit(Challenge entity);

	void remove(Challenge entity);

	Challenge find(Object id);

	List<Challenge> findAll();

	List<Challenge> findRange(int startPosition, int size);

	int count();
}
