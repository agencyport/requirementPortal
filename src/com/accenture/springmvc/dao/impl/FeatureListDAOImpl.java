package com.accenture.springmvc.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.springmvc.dao.FeatureListDAO;
import com.accenture.springmvc.entity.FeatureListingEntity;
import com.accenture.springmvc.entity.RevisionHistoryEntity;
import com.accenture.springmvc.entity.RuleDetailsEntity;
@Repository
public class FeatureListDAOImpl implements FeatureListDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveRevisionHistory(RevisionHistoryEntity rv) {	
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(rv);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}
	@Override
	public void saveFeatureListing(FeatureListingEntity fL) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(fL);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	@Override
	public void saveRuleDetails(RuleDetailsEntity rd) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(rd);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

}
