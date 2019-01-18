package com.accenture.springmvc.cc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.springmvc.entity.RuleDetailsEntity;
import com.accenture.springmvc.service.FeatureListService;

public class RuleDetailsExcelRead {

	public void readSaveRuleDetails(Sheet datatypeSheet,int lobId,FeatureListService featureListService) {
		List<RuleDetailsEntity> listRuleDetails = new ArrayList<RuleDetailsEntity>();
		// read Rule Details
		listRuleDetails = readRuleDetails(datatypeSheet,lobId);
		// save Rule Details
		saveRuleDetails(listRuleDetails,featureListService);
		
	}

	private List<RuleDetailsEntity> readRuleDetails(Sheet datatypeSheet,int lobId) {
		List<RuleDetailsEntity> listRuleDetails = new ArrayList<RuleDetailsEntity>();
		RuleDetailsEntity ruleDetails = null;

		try {
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean flag = false;
			boolean checkIndex = true;
			int startingIndex = 0;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				ruleDetails = new RuleDetailsEntity();
				ruleDetails.setLobId(lobId);
				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					if (checkIndex && currentCell.getCellTypeEnum() == CellType.STRING
							&& currentCell.getStringCellValue().equalsIgnoreCase("Category")) {
						startingIndex = currentCell.getColumnIndex();
						checkIndex = false;
						break;
					}
					if (flag || currentCell.getColumnIndex() == startingIndex) {
						flag = true;
						if (currentCell.getCellTypeEnum() == CellType.STRING) {
							if (currentCell.getColumnIndex() == startingIndex) {
								ruleDetails.setCategory(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 1) {
								ruleDetails.setCoverageAppl(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 2) {
								ruleDetails.setRuleDesc(currentCell.getStringCellValue());
							}

						}
					}
				}
				if (flag) {
					listRuleDetails.add(ruleDetails);
					flag = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRuleDetails;
	}

	private void saveRuleDetails(List<RuleDetailsEntity> listRuleDetails,FeatureListService featureListService) {
		for (RuleDetailsEntity rd : listRuleDetails) {
			featureListService.saveRuleDetails(rd);
		}
	}
	
}
