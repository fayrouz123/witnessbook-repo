package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Competition
 *
 */
@Entity

public class Competition implements Serializable {

	   
	@Id
	private Integer IdCompetition;
	private String DescriptionCompetition;
	public List<Moderator> getModerators() {
		return moderators;
	}
	public void setModerators(List<Moderator> moderators) {
		this.moderators = moderators;
	}
	public List<Witness> getWitnessess() {
		return witnessess;
	}
	public void setWitnessess(List<Witness> witnessess) {
		this.witnessess = witnessess;
	}
	private Date StartDateCompetition;
	private Date EndDateCompetition;
	private List<Moderator>moderators;
	private List<Witness>witnessess;

	
	private static final long serialVersionUID = 1L;

	public Competition() {
		super();
	}   
	public Integer getIdCompetition() {
		return this.IdCompetition;
	}

	public void setIdCompetition(Integer IdCompetition) {
		this.IdCompetition = IdCompetition;
	}   
	public String getDescriptionCompetition() {
		return this.DescriptionCompetition;
	}

	public void setDescriptionCompetition(String DescriptionCompetition) {
		this.DescriptionCompetition = DescriptionCompetition;
	}   
	public Date getStartDateCompetition() {
		return this.StartDateCompetition;
	}

	public void setStartDateCompetition(Date StartDateCompetition) {
		this.StartDateCompetition = StartDateCompetition;
	}   
	public Date getEndDateCompetition() {
		return this.EndDateCompetition;
	}

	public void setEndDateCompetition(Date EndDateCompetition) {
		this.EndDateCompetition = EndDateCompetition;
	}
	public Competition(Integer idCompetition, String descriptionCompetition, Date startDateCompetition,
			Date endDateCompetition) {
		super();
		IdCompetition = idCompetition;
		DescriptionCompetition = descriptionCompetition;
		StartDateCompetition = startDateCompetition;
		EndDateCompetition = endDateCompetition;
	}
	
   
}
