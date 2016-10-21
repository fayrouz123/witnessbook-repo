package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.sigma.witnessbook.entities.ProductOwner;

@Local
public interface IProductOwnerServiceLocal {
	void create(ProductOwner entity);

	ProductOwner edit(ProductOwner entity);

	void remove(ProductOwner entity);

	ProductOwner find(Object id);

	List<ProductOwner> findAll();

	List<ProductOwner> findRange(int startPosition, int size);

	int count();

}
