package tn.esprit.sigma.witnessbook.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Witness extends Users implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String FirstName;
	
	private String LastName;
	
	private Date Birthday;

    @OneToMany
    private List<Challenge> challenges;

    @OneToMany
    private List<Post> posts;

    @OneToMany
    private List<Report> reports;

    @ManyToMany
    private List<WitnessCard> witnessCards;

    @ManyToMany
    private List<Notification> notifications;
    
    
    

    public Witness(int Id,String username, String password, String email, String address, String avatar, Boolean activated,
			Boolean banned, String firstName, String lastName, Date birthday) {
		super(Id,username, password, email, address, avatar, activated, banned);
		FirstName = firstName;
		LastName = lastName;
		Birthday = birthday;
	}
    public Witness()
    {
    	
    }
    
    

	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public Date getBirthday() {
		return Birthday;
	}


	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}


	public List<Challenge> getChallenges() {
        return this.challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Report> getReports() {
        return this.reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<WitnessCard> getWitnessCards() {
        return this.witnessCards;
    }

    public void setWitnessCards(List<WitnessCard> witnessCards) {
        this.witnessCards = witnessCards;
    }

    public List<Notification> getNotifications() {
        return this.notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

}
