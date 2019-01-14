package com.accenture.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.springmvc.service.LobService;

@Controller
public class ExportPdfController {
	@Autowired
	private LobService lobService;
    
    
    @RequestMapping(value = "/viewPDF", method = RequestMethod.POST)
    public ModelAndView viewPDF() throws Exception{
    	List listData= lobService.getLobData(1);
        return new ModelAndView("pdfView", "excelData", listData);
    }     
    @RequestMapping(value = "/viewImagePDF", method = RequestMethod.POST)
    public ModelAndView viewImagePDF() throws Exception{
    	String workingDir = System.getProperty("user.dir");
    	String path = workingDir+"\\images\\domain.png";
    	
    	
        return new ModelAndView("pdfImageView", "path", path);
    }   
}