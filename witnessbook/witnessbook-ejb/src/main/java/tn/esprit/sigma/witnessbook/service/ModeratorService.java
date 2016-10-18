package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.sigma.witnessbook.entities.Moderator;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless
@Named("moderator")
public class ModeratorService extends AbstractService<Moderator> {
	@PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModeratorService() {
        super(Moderator.class);
    }

}
