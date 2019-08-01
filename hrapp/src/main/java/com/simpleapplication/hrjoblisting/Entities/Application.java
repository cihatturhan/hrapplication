package com.simpleapplication.hrjoblisting.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Application")
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private String thoughtsOnJob;
	private int joblistId;
	private int dBFileId;

	
	public Application() {
		
	}
	
	


	
	public Application( String name, String email, String phoneNumber, String address, String thoughtsOnJob,
			int joblistId, int dBFileId) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.thoughtsOnJob = thoughtsOnJob;
		this.joblistId = joblistId;
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


	public int getJoblistId() {
		return joblistId;
	}


	public void setJoblistId(int joblistId) {
		this.joblistId = joblistId;
	}


	public int getdBFileId() {
		return dBFileId;
	}


	public void setdBFileId(int dBFileId) {
		this.dBFileId = dBFileId;
	}
	
	


}
