package com.simpleapplication.hrjoblisting.Business;

import java.util.List;

import com.simpleapplication.hrjoblisting.Entities.Application;

public interface IApplicationService {
	
	public void add(Application application);
	public List<Application> getAll();
	public Application getById(int id);

}
