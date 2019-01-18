package com.accenture.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public List<RuleDetailsEntity> getRulesDetails(int lobId) {
		Session session = sessionFactory.openSession();
		List<RuleDetailsEntity> ruleDetailsLists = null;
		try {
			Criteria cr = session.createCriteria(RuleDetailsEntity.class);
			cr.add(Restrictions.eq("lobId", lobId));
			ruleDetailsLists = cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return ruleDetailsLists;

	}

	@Override
	public List<RevisionHistoryEntity> getRevisionHistory(int lobId) {
		Session session = sessionFactory.openSession();
		List<RevisionHistoryEntity> revisionHistoryLists = null;
		try {
			Criteria cr = session.createCriteria(RevisionHistoryEntity.class);
			cr.add(Restrictions.eq("lobId", lobId));
			revisionHistoryLists = cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return revisionHistoryLists;
	}

	@Override
	public List<FeatureListingEntity> getFeatureListing(int lobId) {
		Session session = sessionFactory.openSession();
		List<FeatureListingEntity> featureListingLists = null;
		try {
			Criteria cr = session.createCriteria(FeatureListingEntity.class);
			cr.add(Restrictions.eq("lobId", lobId));
			featureListingLists = cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return featureListingLists;
	}
	
	@Override
	public void deleteRuleDetails(List<Integer> listRulesId) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("DELETE RuleDetailsEntity WHERE ruleId IN (:rulesId)");
			query.setParameterList("rulesId", listRulesId);
			query.executeUpdate();
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
	public RuleDetailsEntity getRulesDetailsByRulesId(int rulesId) {
		Session session = sessionFactory.openSession();
		RuleDetailsEntity ruleDetails = null;
		try {
			Criteria cr = session.createCriteria(RuleDetailsEntity.class);
			cr.add(Restrictions.eq("ruleId", rulesId));
			ruleDetails = (RuleDetailsEntity) cr.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return ruleDetails;
	}
}
