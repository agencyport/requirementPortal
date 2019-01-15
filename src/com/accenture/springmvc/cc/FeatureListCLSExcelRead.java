package com.accenture.springmvc.cc;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.accenture.springmvc.service.FeatureListService;

public class FeatureListCLSExcelRead {

	public static void readFile(File file,int lobId,FeatureListService featureListService) {
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
					break;
				case "WC Feature Listing":
					FeatureListingExcelRead featureRead = new FeatureListingExcelRead();
					featureRead.readSaveFeatureList(datatypeSheet,lobId,featureListService);
					break;
				case "Coverage Details":

					break;
				case "Rules Details":
					RuleDetailsExcelRead rdRead = new RuleDetailsExcelRead();
					rdRead.readSaveRuleDetails(datatypeSheet,lobId,featureListService);
					break;
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
