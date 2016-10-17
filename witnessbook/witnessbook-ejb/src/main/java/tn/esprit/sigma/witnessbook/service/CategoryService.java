package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.sigma.witnessbook.entities.Category;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless
@Named("category")
public class CategoryService extends AbstractService<Category> {

    @PersistenceContext(unitName = "DEFAULT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryService() {
        super(Category.class);
    }

}
