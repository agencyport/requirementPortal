package com.accenture.springmvc.dao;

import java.util.List;

import com.accenture.springmvc.entity.FeatureListingEntity;
import com.accenture.springmvc.entity.RevisionHistoryEntity;
import com.accenture.springmvc.entity.RuleDetailsEntity;
import com.accenture.springmvc.service.FeatureListService;

public interface FeatureListDAO {
	public void saveRevisionHistory(RevisionHistoryEntity rv);
	public void saveFeatureListing(FeatureListingEntity fL);
	public void saveRuleDetails(RuleDetailsEntity rd);
	public List<RuleDetailsEntity> getRulesDetails(int lobId);
	public RuleDetailsEntity getRulesDetailsByRulesId(int rulesId);
	public List<RevisionHistoryEntity> getRevisionHistory(int lobId);
	public List<FeatureListingEntity> getFeatureListing(int lobId);
	public void deleteRuleDetails(List<Integer> listRulesId);
}
