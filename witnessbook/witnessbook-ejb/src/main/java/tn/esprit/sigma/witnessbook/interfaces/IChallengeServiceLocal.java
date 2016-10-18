package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.sigma.witnessbook.entities.Challenge;
@Local
public interface IChallengeServiceLocal {
	void create(Challenge entity);

	Challenge edit(Challenge entity);

	void remove(Challenge entity);

	Challenge find(Object id);

	List<Challenge> findAll();

	List<Challenge> findRange(int startPosition, int size);

	int count();

}
