package com.simpleapplication.hrjoblisting.DataAccess;

import java.util.List;

import com.simpleapplication.hrjoblisting.Entities.JobApplication;

public interface IJobApplication {
	
	public void add(JobApplication applicaiton);
	public JobApplication getById(int id);
	public List<JobApplication> getAll();
	public List<JobApplication> getByJoblist(int joblistid);
	

}
