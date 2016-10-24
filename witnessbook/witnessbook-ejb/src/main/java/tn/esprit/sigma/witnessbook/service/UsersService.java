package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.sigma.witnessbook.entities.Users;
import tn.esprit.sigma.witnessbook.interfaces.IUserServiceLocal;
import tn.esprit.sigma.witnessbook.interfaces.IUserServiceRemote;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless
@Named("users")
public class UsersService extends AbstractService<Users> implements IUserServiceLocal,IUserServiceRemote{
	@PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersService() {
        super(Users.class);
    }
    
    @Override
	public boolean userAuthentificate(Users user) {
		String jpql = "SELECT u FROM Users u where email=:email and password=:password";	
		Query query = em.createQuery(jpql).setParameter("email", user.getEmail()).setParameter("password", user.getPassword());
		return !query.getResultList().isEmpty();
	}
    @Override
	public boolean changePassword(Users user, String newPassword) {
		String jpql = "UPDATE u FROM Users u "
				+ "set u.password=:newPassword where"
				+ " email=:email "
				+ "and password=:oldpassword";	
		Query query = em.createQuery(jpql)
				.setParameter("mail", user.getEmail())
				.setParameter("oldpassword", user.getPassword())
				.setParameter("newPassword", newPassword);
		return !query.getResultList().isEmpty();
	}
    public void createe(Users u) {
        getEntityManager().persist(u);
    }

}
