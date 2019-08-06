package com.simpleapplication.hrjoblisting.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simpleapplication.hrjoblisting.Entities.JobApplication;




@Repository
public class HibernateJobApplicationDal implements IJobApplication {

	
	
	private EntityManager entityManager;
	
	@Autowired
	public HibernateJobApplicationDal(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void add(JobApplication applicaiton) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(applicaiton);
		
	}

	@Override
	@Transactional
	public JobApplication getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		JobApplication jobApplication = session.get(JobApplication.class, id);
		return jobApplication;
	}

	@Override
	@Transactional
	public List<JobApplication> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<JobApplication> applications= session.createQuery("from Application",JobApplication.class).getResultList();
		return applications; 
	}

	@Override
	public List<JobApplication> getByJoblist(int joblistId) {
		
		Session session = entityManager.unwrap(Session.class);		
		Query<JobApplication> query= session.createQuery("from JobApplication where joblistid = :id");
		query.setParameter("id", joblistId);
		List<JobApplication> application=query.list();
			return application; 

	}



}
