package tn.esprit.sigma.witnessbook.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    
    private String content;

    
    private String attachment;

    
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(targetEntity = Witness.class)
    private Witness witness;

    @ManyToOne(targetEntity = WitnessCard.class)
    private WitnessCard witnessCard;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttachment() {
        return this.attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
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
