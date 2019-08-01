package com.simpleapplication.hrjoblisting.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simpleapplication.hrjoblisting.Entities.Application;




@Repository
public class HibernateApplicationDal implements IApplication {

	
	
	private EntityManager entityManager;
	
	@Autowired
	public HibernateApplicationDal(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void add(Application applicaiton) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(applicaiton);
		
	}

	@Override
	@Transactional
	public Application getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Application application = session.get(Application.class, id);
		return application;
	}

	@Override
	@Transactional
	public List<Application> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Application> applications= session.createQuery("from Application",Application.class).getResultList();
		return applications; 
	}



}
