package tn.esprit.sigma.witnessbook.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    
    private String reason;

    
    private String description;

    
    private Date date;

    private Boolean treated;

    @ManyToOne
    private Witness witness;

    @ManyToOne
    private WitnessCard witnessCard;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean isTreated() {
        return this.treated;
    }

    public void setTreated(Boolean treated) {
        this.treated = treated;
    }

    public Witness getWitness() {
        return this.witness;
    }

    public void setWitness(Witness witness) {
        this.witness = witness;
    }

    public WitnessCard getWitnessCard() {
        return this.witnessCard;
    }

    public void setWitnessCard(WitnessCard witnessCard) {
        this.witnessCard = witnessCard;
    }

}
