package com.simpleapplication.hrjoblisting.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simpleapplication.hrjoblisting.DataAccess.IJobListDal;
import com.simpleapplication.hrjoblisting.Entities.Joblist;


@Service

public class JobListManager implements IJobListService {

	private IJobListDal joblistDal;
	
	@Autowired 
	
	
	public JobListManager(IJobListDal joblistDal) {
		super();
		this.joblistDal = joblistDal;
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
		joblistDal.delete(id);
		
	}

	@Override
	@Transactional
	public Joblist getById(int id) {
		
		return joblistDal.getById(id);
	}
	
	
	
}
