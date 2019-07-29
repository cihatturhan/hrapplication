package com.simpleapplication.hrjoblisting.DataAccess;

import java.util.List;

import com.simpleapplication.hrjoblisting.Entities.JobList;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class HibernateJobListDal implements IJobListDal{
	
	private EntityManager entityManager;
	
	@Autowired
	public HibernateJobListDal(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	@Transactional
	public List<JobList> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<JobList> cities= session.createQuery("from JobList",JobList.class).getResultList();
		return cities; 
	}

	@Override
	public void add(JobList joblist) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(joblist);
		
	}

	@Override
	public void update(JobList joblist) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(joblist);
		
	}

	@Override
	public void delete(JobList joblist) {
		Session session = entityManager.unwrap(Session.class);
		JobList joblistToDelete= session.get(JobList.class,joblist.getId());/// önce sileceğimiz nesyeyi yakalıyoruz
		session.delete(joblistToDelete);
		
	}

	@Override
	public JobList getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		JobList joblist = session.get(JobList.class, id);
		return joblist;
	}

	
}
