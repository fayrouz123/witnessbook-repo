package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: ProductOwner
 *
 */
@Entity

public class ProductOwner extends User implements Serializable {
	
	private List<WitnessCard> WitnessCards;
	
	private static final long serialVersionUID = 1L;
	public ProductOwner(){
		super();
		}
	@OneToMany
	public List<WitnessCard> getWitnessCards() {
		return WitnessCards;
	}
	public void setWitnessCards(List<WitnessCard> witnessCards) {
		WitnessCards = witnessCards;
	}
	public ProductOwner(Integer id, String firstName, String lastName, Date dateNaissance, String email,
			String userName, String password, Boolean statut) {

		super(id, firstName, lastName, dateNaissance, email, userName, password, statut);
	}

}
