package tn.esprit.sigma.witnessbook.interfaces;

import javax.ejb.Local;

import tn.esprit.sigma.witnessbook.entities.Post;

@Local
public interface IPostService {
	void create(Post entity);
}
