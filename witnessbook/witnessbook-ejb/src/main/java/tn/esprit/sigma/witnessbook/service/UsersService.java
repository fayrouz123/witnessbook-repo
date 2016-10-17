package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.sigma.witnessbook.entities.Users;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless
@Named("users")
public class UsersService extends AbstractService<Users> {

    @PersistenceContext(unitName = "DEFAULT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersService() {
        super(Users.class);
    }

}
