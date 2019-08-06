package com.simpleapplication.hrjoblisting.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleapplication.hrjoblisting.DataAccess.IJobApplication;
import com.simpleapplication.hrjoblisting.Entities.JobApplication;

@Service 
public class JobApplicationManager implements IJobApplicationService{
	
	private IJobApplication jobApplicationDal;
	
	@Autowired

	public JobApplicationManager(IJobApplication applicationDal) {
		super();
		this.jobApplicationDal = applicationDal;
	}

	@Override
	public void add(JobApplication application) {
		jobApplicationDal.add(application);
		
	}

	@Override
	public List<JobApplication> getAll() {
		
		return jobApplicationDal.getAll();
	}

	@Override
	public JobApplication getById(int id) {
		
		return jobApplicationDal.getById(id);
	}

	@Override
	public List<JobApplication> getByJoblistId(int id) {
		
		return jobApplicationDal.getByJoblist(id);
	}

}
