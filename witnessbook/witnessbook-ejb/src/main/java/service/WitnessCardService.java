package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.WitnessCard;

/**
 * Session Bean implementation class WitnessCardService
 */
@Stateless

public class WitnessCardService implements WitnessCardServiceRemote, WitnessCardServiceLocal {

	@PersistenceContext
	
	EntityManager em;
   
    public WitnessCardService() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void Addwcs(WitnessCard wc) {
		em.persist(wc);
		
	}

}
