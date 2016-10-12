package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	   
	@Id
	private Integer IdEvent;
	private String NameEvent;
	private Date DateEvent;
	private String PlaceEvent;
	private String DescriptionEvent;
	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}   
	public Integer getIdEvent() {
		return this.IdEvent;
	}

	public void setIdEvent(Integer IdEvent) {
		this.IdEvent = IdEvent;
	}   
	public String getNameEvent() {
		return this.NameEvent;
	}

	public void setNameEvent(String NameEvent) {
		this.NameEvent = NameEvent;
	}   
	public Date getDateEvent() {
		return this.DateEvent;
	}

	public void setDateEvent(Date DateEvent) {
		this.DateEvent = DateEvent;
	}   
	public String getPlaceEvent() {
		return this.PlaceEvent;
	}

	public void setPlaceEvent(String PlaceEvent) {
		this.PlaceEvent = PlaceEvent;
	}   
	public String getDescriptionEvent() {
		return this.DescriptionEvent;
	}

	public void setDescriptionEvent(String DescriptionEvent) {
		this.DescriptionEvent = DescriptionEvent;
	}
   
}
