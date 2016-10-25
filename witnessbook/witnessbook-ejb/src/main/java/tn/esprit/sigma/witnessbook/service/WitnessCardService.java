package tn.esprit.sigma.witnessbook.service;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//import javax.persistence.PersistenceContext;
import tn.esprit.sigma.witnessbook.entities.WitnessCard;
import tn.esprit.sigma.witnessbook.interfaces.IWitnessCardServiceLocal;
import tn.esprit.sigma.witnessbook.interfaces.IWitnessCardServiceRemote;
import tn.esprit.sigma.witnessbook.service.AbstractService;


@Stateless

public class WitnessCardService extends AbstractService<WitnessCard> implements  IWitnessCardServiceLocal,IWitnessCardServiceRemote {
	
	@PersistenceContext
     EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WitnessCardService() {
        super(WitnessCard.class);
    }

	@Override
	public List<WitnessCard> SearchWC(String wc) {
		Query query = em.createQuery("select w from witnesscard w where w.name like :Name").setParameter("Name","%" + wc + "%");
		return query.getResultList();
	}

}
