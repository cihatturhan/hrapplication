package com.simpleapplication.hrjoblisting.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Jobapplication")
public class JobApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private String thoughtsOnJob;
	private String joblistid;
	private int dBFileId;

	
	public JobApplication() {
		
	}
	


	public JobApplication(String name, String email, String phoneNumber, String address, String thoughtsOnJob,
			String joblistid, int dBFileId) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.thoughtsOnJob = thoughtsOnJob;
		this.joblistid = joblistid;
		this.dBFileId = dBFileId;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getThoughtsOnJob() {
		return thoughtsOnJob;
	}


	public void setThoughtsOnJob(String thoughtsOnJob) {
		this.thoughtsOnJob = thoughtsOnJob;
	}


	public String getJoblistid() {
		return joblistid;
	}


	public void setJoblistid(String joblistid) {
		this.joblistid = joblistid;
	}


	public int getdBFileId() {
		return dBFileId;
	}


	public void setdBFileId(int dBFileId) {
		this.dBFileId = dBFileId;
	}
	
	



}
