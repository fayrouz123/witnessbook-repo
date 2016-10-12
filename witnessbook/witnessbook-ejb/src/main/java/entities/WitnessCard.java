package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: WitnessCard
 *
 */
@Entity

public class WitnessCard implements Serializable {

	   
	@Id
	private Integer CardId;
	private String CardName;
	private String CardDescription;
	private String CardAddress;
	private String CardFile;
	private Category category;
	private ProductOwner productowner;
	
	private List<Witness> witnesses;
	private List<Report> reports;
	
	
	
	@ManyToOne
	public ProductOwner getProductowner() {
		return productowner;
	}
	public void setProductowner(ProductOwner productowner) {
		this.productowner = productowner;
	}
	
	public List<Report> getReports() {
		return reports;
	}
	public void setReports(List<Report> reports) {
		this.reports = reports;
	}
	
	public List<Witness> getWitnesses() {
		return witnesses;
	}
	public void setWitnesses(List<Witness> witnesses) {
		this.witnesses = witnesses;
	}
	@ManyToOne
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	private static final long serialVersionUID = 1L;

	public WitnessCard() {
		super();
	}   
	public Integer getCardId() {
		return this.CardId;
	}

	public void setCardId(Integer CardId) {
		this.CardId = CardId;
	}   
	public String getCardName() {
		return this.CardName;
	}

	public void setCardName(String CardName) {
		this.CardName = CardName;
	}   
	public String getCardDescription() {
		return this.CardDescription;
	}

	public void setCardDescription(String CardDescription) {
		this.CardDescription = CardDescription;
	}   
	public String getCardAddress() {
		return this.CardAddress;
	}

	public void setCardAddress(String CardAddress) {
		this.CardAddress = CardAddress;
	}   
	public String getCardFile() {
		return this.CardFile;
	}

	public void setCardFile(String CardFile) {
		this.CardFile = CardFile;
	}
	public WitnessCard(Integer cardId, String cardName, String cardDescription, String cardAddress, String cardFile) {
		super();
		CardId = cardId;
		CardName = cardName;
		CardDescription = cardDescription;
		CardAddress = cardAddress;
		CardFile = cardFile;
	}
	
   
}
