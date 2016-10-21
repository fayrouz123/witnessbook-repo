package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.sigma.witnessbook.entities.BadWord;
import tn.esprit.sigma.witnessbook.interfaces.IBadWordServiceLocal;
import tn.esprit.sigma.witnessbook.interfaces.IBadWordServiceRemote;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless
@Named("badWord")
public class BadWordService extends AbstractService<BadWord> implements IBadWordServiceRemote,IBadWordServiceLocal{

	@PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BadWordService() {
        super(BadWord.class);
    }

}
