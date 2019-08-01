package com.simpleapplication.hrjoblisting.DataAccess;

import java.util.List;

import com.simpleapplication.hrjoblisting.Entities.Application;

public interface IApplication {
	
	public void add(Application applicaiton);
	public Application getById(int id);
	public List<Application> getAll();
	

}
