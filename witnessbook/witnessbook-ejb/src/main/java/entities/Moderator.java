package entities;

import entities.User;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Moderator
 *
 */
@Entity

public class Moderator extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
public Moderator ()
{ super ();}
	public Moderator(Integer id, String firstName, String lastName, Date dateNaissance, String email,
			String userName, String password, Boolean statut) {
		
		super(id, firstName, lastName, dateNaissance, email, userName, password, statut);
	}
   
}
