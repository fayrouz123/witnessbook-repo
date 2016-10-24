package tn.esprit.sigma.witnessbook.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class Users implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    

    
    private String username;

    private String password;

    
    private String email;

    
    private String address;
    
    public String avatar;

    
    private Boolean activated;

    
    private Boolean banned;

    
    
    

	public Users(String username, String password, String email, String address, String avatar, Boolean activated,
			Boolean banned) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.avatar = avatar;
		this.activated = activated;
		this.banned = banned;
	}

	public Users(Integer id, String username, String password, String email, String address, String avatar,
			Boolean activated, Boolean banned) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.avatar = avatar;
		this.activated = activated;
		this.banned = banned;
	}
	
	
	

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Boolean getActivated() {
		return activated;
	}

	public Boolean getBanned() {
		return banned;
	}

	public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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





	public Users() {
	}
	
    

    }
