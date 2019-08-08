package com.simpleapplication.hrjoblisting.Business;

import java.util.List;

import com.simpleapplication.hrjoblisting.Entities.JobApplication;
import com.simpleapplication.hrjoblisting.Exception.JobApplicationException;

public interface IJobApplicationService {
	
	public void add(JobApplication application) throws JobApplicationException;
	public List<JobApplication> getAll();
	public JobApplication getById(int id);
	public List<JobApplication> getByJoblistId(int joblistId);

}
