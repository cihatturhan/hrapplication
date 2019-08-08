package com.simpleapplication.hrjoblisting.Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "Jobapplication")
public class JobApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false,unique = true)
	private String email;
	private String phoneNumber;
	@Column(length = 5000)
	private String address;
	@Column(length = 5000)
	private String thoughtsOnJob;
	@OneToOne
	@JoinColumn(name = "fileid")
	private DBFile dBFile;	
	@ManyToOne
    @JoinColumn(name = "joblistid")
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Joblist joblist;
	

	
	public JobApplication() {
		
	}
	


	public JobApplication(String name, String email, String phoneNumber, String address, String thoughtsOnJob,
			String joblistid, DBFile dBFile, Joblist joblist) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.thoughtsOnJob = thoughtsOnJob;
		this.joblist = joblist;
		this.dBFile = dBFile;
		this.joblist= joblist;
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



	public DBFile getdBFile() {
		return dBFile;
	}



	public void setdBFile(DBFile dBFile) {
		this.dBFile = dBFile;
	}



	public Joblist getJoblist() {
		return joblist;
	}



	public void setJoblist(Joblist joblist) {
		this.joblist = joblist;
	}



//
//	public int getdBFileId() {
//		return dBFileId;
//	}
//
//
//	public void setdBFileId(int dBFileId) {
//		this.dBFileId = dBFileId;
//	}
//	
//	



}
