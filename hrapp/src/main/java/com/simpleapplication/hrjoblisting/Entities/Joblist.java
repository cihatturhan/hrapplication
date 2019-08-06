package com.simpleapplication.hrjoblisting.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Joblist")

public class Joblist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(nullable = false)
	private String jobTitle;
	@Column(length = 5000)
	private String jobDescription;
	private int numberOfPeopleToHire;
	
	@Temporal(TemporalType.DATE )
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lastApplicationDate;
	
	
	
	
	
	
	public Joblist(int id, String jobTitle, String jobDescription, int numberOfPeopleToHire, Date lastApplicationDate,List<JobApplication> jobApplication) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.numberOfPeopleToHire = numberOfPeopleToHire;
		this.lastApplicationDate = lastApplicationDate;

	}
	
	public Joblist(){
		
	}
	
	
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
