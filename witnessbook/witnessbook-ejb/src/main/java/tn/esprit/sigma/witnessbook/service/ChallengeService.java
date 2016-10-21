package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.sigma.witnessbook.entities.Challenge;
import tn.esprit.sigma.witnessbook.interfaces.IChallengeServiceLocal;
import tn.esprit.sigma.witnessbook.interfaces.IChallengeServiceRemote;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless
@Named("challenge")
public class ChallengeService extends AbstractService<Challenge> implements IChallengeServiceLocal,IChallengeServiceRemote{
	@PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChallengeService() {
        super(Challenge.class);
    }

}
