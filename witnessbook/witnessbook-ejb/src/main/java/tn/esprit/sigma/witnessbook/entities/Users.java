package tn.esprit.sigma.witnessbook.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public abstract class Users implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    
    private Long cin;

    
    private String username;

    private String password;

    
    private String email;

    
    private String firstname;

    
    private String lastname;

    
    private Date birthday;

    
    private String address;

    
    private Boolean activated;

    
    private Boolean banned;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

        public Long getCin() {
        return this.cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

        public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

        public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

        public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

        public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

        public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

        public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

        public Boolean isActivated() {
        return this.activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

        public Boolean isBanned() {
        return this.banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    }
