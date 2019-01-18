package com.accenture.springmvc.cc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.accenture.springmvc.entity.FeatureListingEntity;
import com.accenture.springmvc.entity.RevisionHistoryEntity;
import com.accenture.springmvc.service.FeatureListService;

public class FeatureListingExcelRead {

	public List<FeatureListingEntity> readSaveFeatureList(Sheet datatypeSheet, int lobId, FeatureListService featureListService) {
		List<FeatureListingEntity> listFeatureListing = readFeatureList(datatypeSheet, lobId);
		saveFeatureListing(listFeatureListing, featureListService);
		return getFeatureListing(lobId, featureListService);
	}

	private List<FeatureListingEntity> readFeatureList(Sheet datatypeSheet, int lobId) {
		List<FeatureListingEntity> listFeatureListing = new ArrayList<FeatureListingEntity>();
		FeatureListingEntity featureList = null;

		try {
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean flag = false;
			boolean checkIndex = true;
			int startingIndex = -10;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				featureList = new FeatureListingEntity();
				featureList.setLobId(lobId);
				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					if (checkIndex && currentCell.getCellTypeEnum() == CellType.STRING
							&& currentCell.getStringCellValue().equalsIgnoreCase("Page Name")) {
						startingIndex = currentCell.getColumnIndex();
						checkIndex = false;
						break;
					}
					if (flag || currentCell.getColumnIndex() == startingIndex
							&& !"".equals(currentCell.getStringCellValue())) {
						flag = true;
						if (currentCell.getCellTypeEnum() == CellType.STRING) {
							if (currentCell.getColumnIndex() == startingIndex) {
								featureList.setPageName(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 1) {
								featureList.setFeaturefunction(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 2) {
								featureList.setSubFunction(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 3) {
								featureList.setFieldName(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 4) {
								featureList.setFunctionDesc(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 5) {
								featureList.setMandatory(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 6) {
								featureList.setBusinessImapact(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 7) {
								featureList.setIntgFunct(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 8) {
								featureList.setFunPtValidation(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 8) {
								featureList.setSubFunction(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 9) {
								featureList.setIntgSystem(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 10) {
								featureList.setEndorse(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 11) {
								featureList.setRenew(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 12) {
								featureList.setCancel(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 13) {
								featureList.setReInstate(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 14) {
								featureList.setReWrite(currentCell.getStringCellValue());
							}
						}
					}
				}
				if (flag) {
					listFeatureListing.add(featureList);
					flag = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listFeatureListing;
	}

	private void saveFeatureListing(List<FeatureListingEntity> listFeatureListing,
			FeatureListService featureListService) {
		for (FeatureListingEntity fL : listFeatureListing) {
			featureListService.saveFeatureListing(fL);
		}
	}
	private List<FeatureListingEntity> getFeatureListing(int lobId,FeatureListService featureListService) {
		return featureListService.getFeatureListing(lobId);
	}

}
