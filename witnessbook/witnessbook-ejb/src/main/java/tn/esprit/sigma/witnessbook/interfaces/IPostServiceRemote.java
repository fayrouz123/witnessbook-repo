package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.sigma.witnessbook.entities.Post;

@Remote
public interface IPostServiceRemote {

	void create(Post entity);

	Post edit(Post entity);

	void remove(Post entity);

	Post find(Object id);

	List<Post> findAll();

	List<Post> findRange(int startPosition, int size);

	int count();
}
