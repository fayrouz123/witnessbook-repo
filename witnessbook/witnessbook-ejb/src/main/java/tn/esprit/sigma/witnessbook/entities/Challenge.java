package tn.esprit.sigma.witnessbook.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Challenge implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    
    private String description;

    
    private Date startDate;

    
    private Date endDate;

    
    private Float points;

    @ManyToOne(targetEntity = WitnessCard.class)
    private WitnessCard witnessCard;

    @ManyToOne(targetEntity = Witness.class)
    private Witness witness;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getPoints() {
        return this.points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }

    public WitnessCard getWitnessCard() {
        return this.witnessCard;
    }

    public void setWitnessCard(WitnessCard witnessCard) {
        this.witnessCard = witnessCard;
    }

    public Witness getWitness() {
        return this.witness;
    }

    public void setWitness(Witness witness) {
        this.witness = witness;
    }

}
