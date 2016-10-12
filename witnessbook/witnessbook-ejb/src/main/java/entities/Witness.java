package entities;

import entities.User;
import java.io.Serializable;
import java.lang.Double;
import java.util.Date;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Witness
 *
 */
@Entity

public class Witness extends User implements Serializable {

	
	private Double FidelityPoints;
	private static final long serialVersionUID = 1L;
	public Witness()
	{super();}
public Witness(Integer Id, String FirstName, String LastName, Date DateNaissance, String email, String userName,String password, Boolean statut)
{
	super( Id, FirstName, LastName, DateNaissance,  email, userName, password,  statut) ;
	 
}


	
	public Double getFidelityPoints() {
		return this.FidelityPoints;
	}

	public void setFidelityPoints(Double FidelityPoints) {
		this.FidelityPoints = FidelityPoints;
	}
   
}
