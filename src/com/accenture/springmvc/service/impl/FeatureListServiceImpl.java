package com.accenture.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.springmvc.dao.FeatureListDAO;
import com.accenture.springmvc.entity.FeatureListingEntity;
import com.accenture.springmvc.entity.RevisionHistoryEntity;
import com.accenture.springmvc.entity.RuleDetailsEntity;
import com.accenture.springmvc.service.FeatureListService;

@Service
@Transactional
public class FeatureListServiceImpl implements FeatureListService{
	@Autowired
	private FeatureListDAO featureDAO;

	@Override
	public void saveRevisionHistory(RevisionHistoryEntity rv) {
		featureDAO.saveRevisionHistory(rv);
	}

	@Override
	public void saveFeatureListing(FeatureListingEntity fL) {
		featureDAO.saveFeatureListing(fL);		
	}

	@Override
	public void saveRuleDetails(RuleDetailsEntity rd) {
		featureDAO.saveRuleDetails(rd);
	}

	@Override
	public List<RuleDetailsEntity> getRulesDetails(int lobId) {
		return featureDAO.getRulesDetails(lobId);		
	}

	@Override
	public List<RevisionHistoryEntity> getRevisionHistory(int lobId) {		
		return featureDAO.getRevisionHistory(lobId);
	}

	@Override
	public List<FeatureListingEntity> getFeatureListing(int lobId) {
		return featureDAO.getFeatureListing(lobId);
	}

	@Override
	public void deleteRuleDetails(List<Integer> listRulesId) {
	featureDAO.deleteRuleDetails(listRulesId);
		
	}

	@Override
	public RuleDetailsEntity getRulesDetailsByRulesId(int rulesId) {
		return featureDAO.getRulesDetailsByRulesId(rulesId);
	}
}
