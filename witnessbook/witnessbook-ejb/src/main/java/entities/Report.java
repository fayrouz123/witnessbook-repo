package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Report
 *
 */
@Entity

public class Report implements Serializable {

	   
	@Id
	private String ReportId;
	private String ReportReason;
	private String ReportDescription;
	private Date ReportDate;
	private static final long serialVersionUID = 1L;

	public Report() {
		super();
	}   
	public String getReportId() {
		return this.ReportId;
	}

	public void setReportId(String ReportId) {
		this.ReportId = ReportId;
	}   
	public String getReportReason() {
		return this.ReportReason;
	}

	public void setReportReason(String ReportReason) {
		this.ReportReason = ReportReason;
	}   
	public String getReportDescription() {
		return this.ReportDescription;
	}

	public void setReportDescription(String ReportDescription) {
		this.ReportDescription = ReportDescription;
	}   
	public Date getReportDate() {
		return this.ReportDate;
	}

	public void setReportDate(Date ReportDate) {
		this.ReportDate = ReportDate;
	}
	public Report(String reportId, String reportReason, String reportDescription, Date reportDate) {
		super();
		ReportId = reportId;
		ReportReason = reportReason;
		ReportDescription = reportDescription;
		ReportDate = reportDate;
	}
	
	
   
}
