package com.accenture.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.springmvc.entity.RuleDetailsEntity;
import com.accenture.springmvc.service.FeatureListService;
import com.accenture.springmvc.service.LobService;

@Controller
public class ExportPdfController {
	@Autowired
	private FeatureListService featureListService;
    
    
    @RequestMapping(value = "/viewPDF", method = RequestMethod.POST)
    public ModelAndView viewPDF() throws Exception{
    	List<RuleDetailsEntity> listRuleDetails = featureListService.getRulesDetails(1);    	
        return new ModelAndView("pdfView", "ruleDetailsData", listRuleDetails);
    }     
    @RequestMapping(value = "/viewImagePDF", method = RequestMethod.POST)
    public ModelAndView viewImagePDF() throws Exception{
    	String workingDir = System.getProperty("user.dir");
    	String path = workingDir+"\\images\\domain.png";
        return new ModelAndView("pdfImageView", "path", path);
    }   
}