package com.simpleapplication.hrjoblisting.DataAccess;

import java.util.List;
import com.simpleapplication.hrjoblisting.Entities.Joblist;
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
	public List<Joblist> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Joblist> cities= session.createQuery("from Joblist",Joblist.class).getResultList();
		return cities; 
 
	}

	@Override
	@Transactional
	public void add(Joblist joblist) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(joblist);
		
	}


	@Override
	@Transactional
	public void update(Joblist joblist) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(joblist);
		
	}


	@Override
	@Transactional
	public void delete(Joblist joblist) {
		Session session = entityManager.unwrap(Session.class);
		Joblist joblistToDelete= session.get(Joblist.class,joblist.getId());/// önce sileceğimiz nesyeyi yakalıyoruz
		session.delete(joblistToDelete);
		
	}


	@Override
	@Transactional
	public Joblist getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Joblist joblist = session.get(Joblist.class, id);
		return joblist;

	}

	
}
