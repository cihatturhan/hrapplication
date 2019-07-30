package com.simpleapplication.hrjoblisting.Entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="Joblist")

public class Joblist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="jobtitle")
	private String jobTitle;
	@Column(name="jobdescription")
	private String jobDescription;
	@Column(name="numberofpeopletohire")
	private int numberOfPeopleToHire;
	
	@Temporal(TemporalType.DATE )
	@Column(name="lastapplicationdate")
	private Date lastApplicationDate;
	
	
	
	
	
	
	
	public Joblist(int id, String jobTitle, String jobDescription, int numberOfPeopleToHire, Date lastApplicationDate) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.numberOfPeopleToHire = numberOfPeopleToHire;
		this.lastApplicationDate = lastApplicationDate;
	}
	
	public Joblist(){}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public int getNumberOfPeopleToHire() {
		return numberOfPeopleToHire;
	}
	public void setNumberOfPeopleToHire(int numberOfPeopleToHire) {
		this.numberOfPeopleToHire = numberOfPeopleToHire;
	}
	public Date getLastApplicationDate() {
		return lastApplicationDate;
	}
	public void setLastApplicationDate(Date lastApplicationDate) {
		this.lastApplicationDate = lastApplicationDate;
	}
	
	
	
	

}
