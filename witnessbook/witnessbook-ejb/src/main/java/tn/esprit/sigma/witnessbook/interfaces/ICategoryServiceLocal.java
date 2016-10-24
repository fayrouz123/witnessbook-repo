package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.sigma.witnessbook.entities.Category;

@Local
public interface ICategoryServiceLocal {
	void create(Category entity);

	Category edit(Category entity);

	void remove(Category entity);

	Category find(Object id);

	List<Category> findAll();

	List<Category> findRange(int startPosition, int size);

	int count();
    public List<Category> findAllCategoryName();
}
