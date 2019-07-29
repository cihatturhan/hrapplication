package com.simpleapplication.hrjoblisting.DataAccess;

import java.util.List;

import com.simpleapplication.hrjoblisting.Entities.JobList;

public interface IJobListDal {
	
	List<JobList> getAll();
	void add (JobList joblist);
	void update (JobList joblist);
	void delete (JobList joblist);
	JobList getById(int id);
	

}
