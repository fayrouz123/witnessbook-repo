package tn.esprit.sigma.witnessbook.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class ProductOwner extends Users implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ProductName;
   
	public ProductOwner() {
	}
	


	@OneToMany
    private List<WitnessCard> witnessCards;
	
	

    public ProductOwner(String username, String password, String email, String address, String avatar,
			Boolean activated, Boolean banned, String productName) {
		super(username, password, email, address, avatar, activated, banned);
		ProductName = productName;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public List<WitnessCard> getWitnessCards() {
        return this.witnessCards;
    }

    public void setWitnessCards(List<WitnessCard> witnessCards) {
        this.witnessCards = witnessCards;
    }
    

}
