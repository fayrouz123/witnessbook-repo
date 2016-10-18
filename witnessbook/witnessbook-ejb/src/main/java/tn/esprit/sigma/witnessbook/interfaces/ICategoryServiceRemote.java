package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;
import java.util.Locale.Category;

import javax.ejb.Remote;

@Remote
public interface ICategoryServiceRemote {

	void create(Category entity);

	Category edit(Category entity);

	void remove(Category entity);

	Category find(Object id);

	List<Category> findAll();

	List<Category> findRange(int startPosition, int size);

	int count();
}
