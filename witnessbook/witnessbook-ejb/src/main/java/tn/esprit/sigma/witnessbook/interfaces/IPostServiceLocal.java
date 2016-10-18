package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.sigma.witnessbook.entities.Post;
@Local
public interface IPostServiceLocal {
	void create(Post entity);
	 Post edit(Post entity);
	 void remove(Post entity);
	 Post find(Object id);
	 List<Post> findAll();
	 List<Post> findRange(int startPosition, int size);
	 int count();

}
