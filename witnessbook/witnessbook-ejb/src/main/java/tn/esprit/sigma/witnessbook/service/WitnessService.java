package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.sigma.witnessbook.entities.Witness;
import tn.esprit.sigma.witnessbook.interfaces.IWitnessServiceLocal;
import tn.esprit.sigma.witnessbook.interfaces.IWitnessServiceRemote;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless
@Named("witness")
public class WitnessService extends AbstractService<Witness> implements IWitnessServiceLocal,IWitnessServiceRemote{
	@PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WitnessService() {
        super(Witness.class);
    }
    
    

}
