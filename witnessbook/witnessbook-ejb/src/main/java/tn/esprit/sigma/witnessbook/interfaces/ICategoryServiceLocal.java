package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;
import java.util.Locale.Category;

import javax.ejb.Local;

@Local
public interface ICategoryServiceLocal {
	void create(Category entity);
	 Category edit(Category entity);
	 void remove(Category entity);
	 Category find(Object id);
	 List<Category> findAll();
	 List<Category> findRange(int startPosition, int size);
	 int count();
}
