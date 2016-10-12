package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: ProductOwner
 *
 */
@Entity

public class ProductOwner extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	public ProductOwner(){
		super();
		}
	public ProductOwner(Integer id, String firstName, String lastName, Date dateNaissance, String email,
			String userName, String password, Boolean statut) {

		super(id, firstName, lastName, dateNaissance, email, userName, password, statut);
	}

}
