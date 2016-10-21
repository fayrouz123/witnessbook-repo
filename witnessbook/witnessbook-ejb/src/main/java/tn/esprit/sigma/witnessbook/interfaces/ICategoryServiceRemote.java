package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.sigma.witnessbook.entities.Category;

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
