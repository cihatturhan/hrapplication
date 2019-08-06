package com.simpleapplication.hrjoblisting.Business;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simpleapplication.hrjoblisting.DataAccess.IJobListDal;
import com.simpleapplication.hrjoblisting.DataAccess.DBFileRepository;
import com.simpleapplication.hrjoblisting.Entities.JobApplication;
import com.simpleapplication.hrjoblisting.Entities.Joblist;


@Service

public class JobListManager implements IJobListService {

	private IJobListDal joblistDal;
     private IJobApplicationService jobApplicationService;
	private DBFileRepository dBFileRepository;
	
	@Autowired 
	
	
	public JobListManager(IJobListDal joblistDal, IJobApplicationService jobApplicationService, DBFileRepository dBFileRepository) {
		super();
		this.joblistDal = joblistDal;
		this.jobApplicationService= jobApplicationService;
		this.dBFileRepository=dBFileRepository;
	}

	@Override
	@Transactional
	public List<Joblist> getAll() {
		
		return joblistDal.getAll();
	}

	@Override
	@Transactional
	public void add(Joblist joblist) {
		joblistDal.add(joblist);
		
	}

	@Override
	@Transactional
	public void update(Joblist joblist) {
		joblistDal.update(joblist);
		
	}

	@Override
	@Transactional
	public void delete(int id) {

		List<JobApplication> jobApplications=jobApplicationService.getByJoblistId(id);

		joblistDal.delete(id);
		try {
			// Files are saved without any relation before applications are saved so that they have to be removed manually.
			for( JobApplication jobApplication: jobApplications) {
				dBFileRepository.deleteById(jobApplication.getdBFile().getId());
				
			}
			
		}catch (Exception e){
			System.out.println(e+"-- Exception occured while file is being deleted");
		}
	

		
	}

	@Override
	@Transactional
	public Joblist getById(int id) {
		
		return joblistDal.getById(id);
	}
	
	
	
}
