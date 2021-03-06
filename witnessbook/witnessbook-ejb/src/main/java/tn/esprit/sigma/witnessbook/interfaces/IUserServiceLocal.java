package tn.esprit.sigma.witnessbook.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.sigma.witnessbook.entities.Users;
@Local
public interface IUserServiceLocal {
	void create(Users entity);

	Users edit(Users entity);

	void remove(Users entity);

	Users find(Object id);

	List<Users> findAll();

	List<Users> findRange(int startPosition, int size);

	int count();
	public boolean userAuthentificate(Users user) ;
	public boolean changePassword(Users user, String newPassword) ;
    public void createe(Users u) ;

}
