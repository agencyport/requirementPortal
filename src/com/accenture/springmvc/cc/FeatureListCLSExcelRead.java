package com.accenture.springmvc.cc;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.springmvc.service.FeatureListService;

public class FeatureListCLSExcelRead {

	public static ModelAndView readFile(File file,int lobId,FeatureListService featureListService,ModelAndView model) {
		FeatureListingDisplay feature = new FeatureListingDisplay();
		try {
			FileInputStream excelFile = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet;
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				datatypeSheet = workbook.getSheetAt(i);
				
				switch (workbook.getSheetName(i)) {
				case "Revision History":
					RevisionHistoryExcelRead rvRead = new RevisionHistoryExcelRead();
				   rvRead.readSaveRevisionHistory(datatypeSheet,lobId,featureListService);
					feature.setRevisionHistory(lobId, featureListService, model);
					break;
				case "WC Feature Listing":
					FeatureListingExcelRead featureRead = new FeatureListingExcelRead();
					featureRead.readSaveFeatureList(datatypeSheet,lobId,featureListService);
					feature.setFeatureListing(lobId, featureListService, model);
					break;
				case "Coverage Details":

					break;
				case "Rules Details":
					RuleDetailsExcelRead rdRead = new RuleDetailsExcelRead();
					 rdRead.readSaveRuleDetails(datatypeSheet,lobId,featureListService);
					feature.setRulesDetailsModel(lobId, featureListService, model);
					break;
				}
			}
			workbook.close();		
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return model;
	}
}
