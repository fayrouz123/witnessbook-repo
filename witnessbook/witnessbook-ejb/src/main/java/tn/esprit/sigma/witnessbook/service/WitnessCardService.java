package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import javax.persistence.PersistenceContext;
import tn.esprit.sigma.witnessbook.entities.WitnessCard;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless

public class WitnessCardService extends AbstractService<WitnessCard> implements  WitnessCardServiceLocal,WitnessCardServiceRemote {
	
	@PersistenceContext
     EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WitnessCardService() {
        super(WitnessCard.class);
    }

}
