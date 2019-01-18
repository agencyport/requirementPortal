package com.accenture.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.springmvc.cc.FeatureListingDisplay;
import com.accenture.springmvc.entity.DynDisplayColumnBean;
import com.accenture.springmvc.entity.RuleDetailsEntity;
import com.accenture.springmvc.service.FeatureListService;

@Controller
public class DeleteController {	
	@Autowired
	private FeatureListService featureListService;
	FeatureListingDisplay featureDisplay = new FeatureListingDisplay();

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("lobmenu");
		RuleDetailsEntity ruleDetails = new RuleDetailsEntity();
		if (request.getParameter("displayId") != null && request.getParameter("lobId") != null) {
		ruleDetails.setRuleId(Integer.parseInt(request.getParameter("displayId")));		
		ruleDetails.setLobId(Integer.parseInt(request.getParameter("lobId")));
		ruleDetails.setCategory(request.getParameter("category") );
		ruleDetails.setCoverageAppl(request.getParameter("coverage"));
		ruleDetails.setRuleDesc(request.getParameter("desc"));
		}
		featureListService.saveRuleDetails(ruleDetails);
		featureDisplay.setRulesDetailsModel(1, featureListService, model);	
		return model;
	}
	
	@RequestMapping(value = "updateDelete", method = RequestMethod.POST)
	public ModelAndView updateDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("lobmenu");
		if (request.getParameter("update") != null) {
			String selectededitId[] = request.getParameterValues("checkboxedit");
			model = new ModelAndView("lobedit");
			return update(selectededitId,model);
		} else if (request.getParameter("delete") != null) {
			String selecteddeleteId[] = request.getParameterValues("checkboxdelete");
			model = new ModelAndView("lobmenu");
			return delete(selecteddeleteId,model);
		}
		return model;		
		
	}
	
	@RequestMapping(value = "lobMenu", method = RequestMethod.POST)
	public ModelAndView lobMenu(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("lobmenu");
		featureDisplay.setRulesDetailsModel(1, featureListService, model);		
		return model;			
	}

	private ModelAndView delete(String[] selectedId,ModelAndView model) {		
		if (selectedId!=null && selectedId.length > 0) {
			List<Integer> listRulesId = new ArrayList<>();
			for (int i = 0; i < selectedId.length; i++) {
				listRulesId.add(Integer.parseInt(selectedId[i]));
			}			
			featureListService.deleteRuleDetails(listRulesId);
		}
		featureDisplay.setRulesDetailsModel(1, featureListService,model);	
		return model;
	}
	private ModelAndView update(String[] selectedId,ModelAndView model) {		
		if (selectedId != null && selectedId.length > 0) {
			DynDisplayColumnBean dynDisplayColumnBean = new DynDisplayColumnBean();
			
			RuleDetailsEntity ruleDetails =	featureListService.getRulesDetailsByRulesId(Integer.parseInt(selectedId[0]));
			String displayData[] ={ruleDetails.getCategory(),ruleDetails.getCoverageAppl(),ruleDetails.getRuleDesc()};
					
		dynDisplayColumnBean.setDisplayId(ruleDetails.getRuleId());
		dynDisplayColumnBean.setDisplayData(displayData);
		dynDisplayColumnBean.setLobId(ruleDetails.getLobId());
		dynDisplayColumnBean.setTitle(displayData);
		model.addObject("dynDisplayColumnBean", dynDisplayColumnBean);
		}
		return model;
	}

}