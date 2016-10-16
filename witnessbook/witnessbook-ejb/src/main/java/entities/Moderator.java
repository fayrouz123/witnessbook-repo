package entities;

import entities.User;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Moderator
 *
 */
@Entity

public class Moderator extends User implements Serializable {
 private List<Event>events;
 private List<Competition>competitions;

 
	
	public List<Event> getEvents() {
	return events;
}
public void setEvents(List<Event> events) {
	this.events = events;
}
public List<Competition> getCompetitions() {
	return competitions;
}
public void setCompetitions(List<Competition> competitions) {
	this.competitions = competitions;
}
	private static final long serialVersionUID = 1L;
public Moderator ()
{ super ();}
	public Moderator(Integer id, String firstName, String lastName, Date dateNaissance, String email,
			String userName, String password, Boolean statut) {
		
		super(id, firstName, lastName, dateNaissance, email, userName, password, statut);
	}
   
}
