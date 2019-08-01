package com.simpleapplication.hrjoblisting.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleapplication.hrjoblisting.DataAccess.IApplication;
import com.simpleapplication.hrjoblisting.Entities.Application;

@Service 
public class ApplicationManager implements IApplicationService{
	
	private IApplication applicationDal;
	
	@Autowired

	public ApplicationManager(IApplication applicationDal) {
		super();
		this.applicationDal = applicationDal;
	}

	@Override
	public void add(Application application) {
		applicationDal.add(application);
		
	}

	@Override
	public List<Application> getAll() {
		
		return applicationDal.getAll();
	}

	@Override
	public Application getById(int id) {
		
		return applicationDal.getById(id);
	}

}
