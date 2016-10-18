package tn.esprit.sigma.witnessbook.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class ProductOwner extends Users implements Serializable {
	private static final long serialVersionUID = 1L;

    @OneToMany(targetEntity = WitnessCard.class, mappedBy = "productOwner")
    private List<WitnessCard> witnessCards;

    public List<WitnessCard> getWitnessCards() {
        return this.witnessCards;
    }

    public void setWitnessCards(List<WitnessCard> witnessCards) {
        this.witnessCards = witnessCards;
    }

}
