package tn.esprit.sigma.witnessbook.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class WitnessCard implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    
    private String name;

    
    private String description;

    private String address;

    
    private String attachement;

    @ManyToOne
    private ProductOwner productOwner;

    @ManyToOne
    private Category category;

    @OneToMany
    private List<Event> events;

    @OneToMany
    private List<Challenge> challenges;

    @OneToMany
    private List<Post> posts;

    @OneToMany
    private List<Report> reports;

    @ManyToMany
    private List<Witness> witnesses;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAttachement() {
        return this.attachement;
    }

    public void setAttachement(String attachement) {
        this.attachement = attachement;
    }

    public ProductOwner getProductOwner() {
        return this.productOwner;
    }

    public void setProductOwner(ProductOwner productOwner) {
        this.productOwner = productOwner;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
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

    public List<Witness> getWitnesses() {
        return this.witnesses;
    }

    public void setWitnesses(List<Witness> witnesses) {
        this.witnesses = witnesses;
    }

}
