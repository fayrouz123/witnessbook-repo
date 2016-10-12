package entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	private Integer Id;
	private String FirstName;
	private String LastName;
	private Date DateNaissance;
	private String Email;
	private String UserName;
	private String Password;
	private Boolean Statut;
	private static final long serialVersionUID = 1L;

	public User()
	{super();}
	   
	public User(Integer id, String firstName, String lastName, Date dateNaissance, String email, String userName,
			String password, Boolean statut) {
	
		FirstName = firstName;
		LastName = lastName;
		DateNaissance = dateNaissance;
		Email = email;
		UserName = userName;
		Password = password;
		Statut = statut;
	}

	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	public String getFirstName() {
		return this.FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}   
	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}   
	public Date getDateNaissance() {
		return this.DateNaissance;
	}

	public void setDateNaissance(Date DateNaissance) {
		this.DateNaissance = DateNaissance;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}   
	public String getUserName() {
		return this.UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}   
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}   
	public Boolean getStatut() {
		return this.Statut;
	}

	public void setStatut(Boolean Statut) {
		this.Statut = Statut;
	}
   
}
