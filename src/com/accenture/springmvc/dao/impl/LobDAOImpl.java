package com.accenture.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.springmvc.dao.LobDAO;
import com.accenture.springmvc.entity.Employee;
import com.accenture.springmvc.entity.Lob;
import com.accenture.springmvc.entity.LobData;

@Repository
public class LobDAOImpl implements LobDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void createLob(Lob lob) {
		Session session = sessionFactory.openSession();
		//	Transaction tx = session.beginTransaction();
		List<Lob> lobList = getLobs();
		boolean addedLob = false;
		for (Lob lob2 : lobList) {
			if(lob.getLobName().equals(lob2.getLobName())){
				addedLob =true;
			}
		}
		if(!addedLob){
			session.save(lob);
		}
		//	tx.commit();
			session.close();
		
	}



	@Override
	public void saveLobData(LobData lobData) {
		Session session = sessionFactory.openSession();
		session.save(lobData);
		
	}

	@Override
	public List<LobData> getLobData(long lobData) {
		Session session = sessionFactory.openSession();
		List<LobData> lobList = null;
		try{
			Criteria cr = session.createCriteria(LobData.class);
			cr.add(Restrictions.eq("lobReferenceId", lobData));
			lobList = cr.list();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lobList;
		
	}



	@Override
	public List<Lob> getLobs() {
		Session session = sessionFactory.openSession();
		List<Lob> lobList = null;
		try{			
		String hql = "FROM com.accenture.springmvc.entity.Lob";
		Query query = session.createQuery(hql);
		lobList = query.list();	
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lobList;
	}
}
