package com.accenture.springmvc.dao;

import com.accenture.springmvc.entity.FeatureListingEntity;
import com.accenture.springmvc.entity.RevisionHistoryEntity;
import com.accenture.springmvc.entity.RuleDetailsEntity;

public interface FeatureListDAO {
	public void saveRevisionHistory(RevisionHistoryEntity rv);
	public void saveFeatureListing(FeatureListingEntity fL);
	public void saveRuleDetails(RuleDetailsEntity rd);
}
