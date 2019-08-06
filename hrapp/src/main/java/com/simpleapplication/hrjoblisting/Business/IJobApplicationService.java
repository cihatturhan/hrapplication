package com.simpleapplication.hrjoblisting.Business;

import java.util.List;

import com.simpleapplication.hrjoblisting.Entities.JobApplication;

public interface IJobApplicationService {
	
	public void add(JobApplication application);
	public List<JobApplication> getAll();
	public JobApplication getById(int id);
	public List<JobApplication> getByJoblistId(int joblistId);

}
