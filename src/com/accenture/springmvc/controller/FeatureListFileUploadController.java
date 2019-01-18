package com.accenture.springmvc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.springmvc.cc.FeatureListCLSExcelRead;
import com.accenture.springmvc.service.FeatureListService;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FeatureListFileUploadController {
	@Autowired
	private FeatureListService featureListService;	
	/**
	 * Upload single file using Spring Controller
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody ModelAndView uploadFileHandler(@ModelAttribute("lobId")int lobId,@RequestParam("file") MultipartFile fileUpload)
			throws IOException {
		ModelAndView model = new ModelAndView("lobmenu");		
		if (!fileUpload.isEmpty()) {
			byte[] bytes = fileUpload.getBytes();
			// Creating the directory to store file
			String rootPath = System.getProperty("/");
			File dir = new File(rootPath + File.separator + "resource");
			if (!dir.exists())
				dir.mkdirs();
			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath() + File.separator + fileUpload.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			System.out.println("Path is :" + serverFile);			
			model = FeatureListCLSExcelRead.readFile(serverFile,lobId,featureListService,model);
		}
		return model;
	}

}
