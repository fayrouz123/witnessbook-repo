package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import javax.persistence.PersistenceContext;
import tn.esprit.sigma.witnessbook.entities.WitnessCard;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless
@Named("witnessCard")
public class WitnessCardService extends AbstractService<WitnessCard> implements  WitnessCardServiceLocal,WitnessCardServiceRemote {
	@PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WitnessCardService() {
        super(WitnessCard.class);
    }

}
