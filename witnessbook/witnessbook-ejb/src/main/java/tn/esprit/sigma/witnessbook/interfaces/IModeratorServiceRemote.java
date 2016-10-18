package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.sigma.witnessbook.entities.Moderator;

@Remote
public interface IModeratorServiceRemote {

	void create(Moderator entity);

	Moderator edit(Moderator entity);

	void remove(Moderator entity);

	Moderator find(Object id);

	List<Moderator> findAll();

	List<Moderator> findRange(int startPosition, int size);

	int count();
}
