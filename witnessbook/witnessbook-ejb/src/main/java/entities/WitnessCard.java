package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
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
