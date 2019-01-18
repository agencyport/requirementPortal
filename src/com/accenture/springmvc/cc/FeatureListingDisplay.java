package com.accenture.springmvc.cc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.accenture.springmvc.entity.DynDisplayColumnBean;
import com.accenture.springmvc.entity.FeatureListingEntity;
import com.accenture.springmvc.entity.RevisionHistoryEntity;
import com.accenture.springmvc.entity.RuleDetailsEntity;
import com.accenture.springmvc.service.FeatureListService;

public class FeatureListingDisplay {
	List<DynDisplayColumnBean> dynDisplayDetails = new ArrayList<DynDisplayColumnBean>();
	DynDisplayTable displayTable = new DynDisplayTable();
	public void setFeatureListing(int lobId,FeatureListService featureListService,ModelAndView model) {
		List<FeatureListingEntity> featureListingLists = featureListService.getFeatureListing(lobId);
		dynDisplayDetails = displayTable.displayFeatureListing(featureListingLists);
		model.addObject("dynFeatureListing", dynDisplayDetails);		
	}
	public void setRevisionHistory(int lobId,FeatureListService featureListService,ModelAndView model) {
		List<RevisionHistoryEntity> listRevisionHistory = featureListService.getRevisionHistory(lobId);
		dynDisplayDetails = displayTable.displayRevisionHistory(listRevisionHistory);
		model.addObject("revisionHistoryData", dynDisplayDetails);		
	}
	public void setRulesDetailsModel(int lobId,FeatureListService featureListService,ModelAndView model) {
		List<RuleDetailsEntity> listRuleDetails =featureListService.getRulesDetails(lobId);
		dynDisplayDetails = displayTable.displayRulesDetails(listRuleDetails);
		model.addObject("ruleDetailsData", dynDisplayDetails);		
	}
}
