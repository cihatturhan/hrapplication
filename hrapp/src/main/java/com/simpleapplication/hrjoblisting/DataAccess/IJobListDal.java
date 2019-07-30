package com.simpleapplication.hrjoblisting.DataAccess;

import java.util.List;

import com.simpleapplication.hrjoblisting.Entities.Joblist;

public interface IJobListDal {
	
	List<Joblist> getAll();
	void add (Joblist joblist);
	void update (Joblist joblist);
	void delete (Joblist joblist);
	Joblist getById(int id);
	

}