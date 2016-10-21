package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.sigma.witnessbook.entities.ProductOwner;
import tn.esprit.sigma.witnessbook.interfaces.IProductOwnerServiceLocal;
import tn.esprit.sigma.witnessbook.interfaces.IProductOwnerServiceRemote;

@Stateless
@Named("productOwner")
public class ProductOwnerService extends AbstractService<ProductOwner> implements IProductOwnerServiceLocal,IProductOwnerServiceRemote {
	@PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductOwnerService() {
        super(ProductOwner.class);
    }

	
}
