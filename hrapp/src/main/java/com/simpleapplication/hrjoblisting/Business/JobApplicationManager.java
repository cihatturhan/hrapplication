package com.simpleapplication.hrjoblisting.Business;

import java.util.List;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleapplication.hrjoblisting.DataAccess.DBFileRepository;
import com.simpleapplication.hrjoblisting.DataAccess.IJobApplication;
import com.simpleapplication.hrjoblisting.Entities.JobApplication;
import com.simpleapplication.hrjoblisting.Exception.JobApplicationException;

@Service 
public class JobApplicationManager implements IJobApplicationService{
	
	private IJobApplication jobApplicationDal;
	private DBFileRepository dBFileRepository;
	
	@Autowired

	public JobApplicationManager(IJobApplication applicationDal,DBFileRepository dBFileRepository) {
		super();
		this.jobApplicationDal = applicationDal;
		this.dBFileRepository= dBFileRepository;
	}



	@Override
	public void add(JobApplication application) throws JobApplicationException {
		if(application.getdBFile().getId()==0) 
			throw new JobApplicationException("Resume was not uploaded");
		if(jobApplicationDal.isEmailInUse(application.getEmail())) {
			dBFileRepository.deleteById(application.getdBFile().getId());// uploaded resume is deleted
			throw new JobApplicationException("Email is already registered, Please use another email");
			
		}
			
		
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
