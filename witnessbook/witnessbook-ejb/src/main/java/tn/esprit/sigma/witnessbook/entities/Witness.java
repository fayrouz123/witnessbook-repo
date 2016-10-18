package tn.esprit.sigma.witnessbook.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Witness extends Users implements Serializable {
	private static final long serialVersionUID = 1L;

    @OneToMany(targetEntity = Challenge.class, mappedBy = "witness")
    private List<Challenge> challenges;

    @OneToMany(targetEntity = Post.class, mappedBy = "witness")
    private List<Post> posts;

    @OneToMany(targetEntity = Report.class, mappedBy = "witness")
    private List<Report> reports;

    @ManyToMany(targetEntity = WitnessCard.class, mappedBy = "witnesses")
    private List<WitnessCard> witnessCards;

    @ManyToMany(targetEntity = Notification.class, mappedBy = "witnesses")
    private List<Notification> notifications;

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
