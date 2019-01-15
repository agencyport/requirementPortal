package com.accenture.springmvc.service.impl;

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

}
