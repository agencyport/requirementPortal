package com.accenture.springmvc.cc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.accenture.springmvc.entity.DynDisplayColumnBean;
import com.accenture.springmvc.entity.FeatureListingEntity;
import com.accenture.springmvc.entity.RevisionHistoryEntity;
import com.accenture.springmvc.entity.RuleDetailsEntity;

public class DynDisplayTable {
	
	public List<DynDisplayColumnBean> displayRulesDetails(List<RuleDetailsEntity> listRuleDetails) {
		List<DynDisplayColumnBean> dynRulesDetails = new ArrayList<DynDisplayColumnBean>();
		String [] displayData = new String[3];
		String [] displayTitle ={"Category","Coverage Appl","Rule Desc"};
		if (listRuleDetails != null) {
			DynDisplayColumnBean dynDisplayColumnBean;			
			for (int i = 0; i < listRuleDetails.size(); i++) {				
				dynDisplayColumnBean = new DynDisplayColumnBean();
				displayData = new String[3];
				dynDisplayColumnBean.setDisplayId(listRuleDetails.get(i).getRuleId());				
				displayData[0]=listRuleDetails.get(i).getCategory();
				displayData[1]=listRuleDetails.get(i).getCoverageAppl();
				displayData[2]=listRuleDetails.get(i).getRuleDesc();
				dynDisplayColumnBean.setDisplayData(displayData);
				dynDisplayColumnBean.setLobId(listRuleDetails.get(i).getLobId());
				dynDisplayColumnBean.setTitle(displayTitle);
				dynRulesDetails.add(dynDisplayColumnBean);
			}
		}
		return dynRulesDetails;
	}
	public List<DynDisplayColumnBean> displayRevisionHistory(List<RevisionHistoryEntity> listRevisionHistory) {
		List<DynDisplayColumnBean> dynRevisionHistory = new ArrayList<DynDisplayColumnBean>();
		String [] displayData = new String[10];
		String [] displayTitle ={"Date","Version","Description","Author","Reviewed By"};
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");		
		if (listRevisionHistory != null) {
			DynDisplayColumnBean dynDisplayColumnBean;			
			for (int i = 0; i < listRevisionHistory.size(); i++) {				
				dynDisplayColumnBean = new DynDisplayColumnBean();
				dynDisplayColumnBean.setDisplayId(listRevisionHistory.get(i).getRevisionHistoryId());				
				displayData[0]=dateFormat.format(listRevisionHistory.get(i).getDate());
				displayData[1]=listRevisionHistory.get(i).getVersion();
				displayData[2]=listRevisionHistory.get(i).getDescription();
				displayData[3]=listRevisionHistory.get(i).getAuthor();
				displayData[4]=listRevisionHistory.get(i).getReviewedBy();
				dynDisplayColumnBean.setDisplayData(displayData);
				dynDisplayColumnBean.setLobId(listRevisionHistory.get(i).getLobId());
				dynDisplayColumnBean.setTitle(displayTitle);
				dynRevisionHistory.add(dynDisplayColumnBean);
			}
		}
		return dynRevisionHistory;
	}
	public List<DynDisplayColumnBean> displayFeatureListing(List<FeatureListingEntity> listFeatureListing) {
		List<DynDisplayColumnBean> dynFeatureListing = new ArrayList<DynDisplayColumnBean>();
		String [] displayData = new String[20];
		String [] displayTitle ={"Category","Coverage Appl","Rule Desc"};
		if (listFeatureListing != null) {
			DynDisplayColumnBean dynDisplayColumnBean;			
			for (int i = 0; i < listFeatureListing.size(); i++) {				
				dynDisplayColumnBean = new DynDisplayColumnBean();
				dynDisplayColumnBean.setDisplayId(listFeatureListing.get(i).getFeatureListId());				
				displayData[0]=listFeatureListing.get(i).getPageName();
				displayData[1]=listFeatureListing.get(i).getFeaturefunction();
				displayData[2]=listFeatureListing.get(i).getSubFunction();
				displayData[3]=listFeatureListing.get(i).getFieldName();
				displayData[4]=listFeatureListing.get(i).getFunctionDesc();
				displayData[5]=listFeatureListing.get(i).getMandatory();
				displayData[6]=listFeatureListing.get(i).getBusinessImapact();
				displayData[7]=listFeatureListing.get(i).getIntgFunct();
				displayData[8]=listFeatureListing.get(i).getFunPtValidation();
				displayData[9]=listFeatureListing.get(i).getIntgSystem();
				displayData[10]=listFeatureListing.get(i).getEndorse();
				displayData[11]=listFeatureListing.get(i).getRenew();
				displayData[12]=listFeatureListing.get(i).getCancel();
				displayData[13]=listFeatureListing.get(i).getReInstate();	
				displayData[14]=listFeatureListing.get(i).getReWrite();
				dynDisplayColumnBean.setDisplayData(displayData);
				dynDisplayColumnBean.setLobId(listFeatureListing.get(i).getLobId());
				dynDisplayColumnBean.setTitle(displayTitle);
				dynFeatureListing.add(dynDisplayColumnBean);
			}
		}
		return dynFeatureListing;
	}
}
