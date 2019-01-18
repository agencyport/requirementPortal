package com.accenture.springmvc.cc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.accenture.springmvc.entity.RevisionHistoryEntity;
import com.accenture.springmvc.entity.RuleDetailsEntity;
import com.accenture.springmvc.service.FeatureListService;

public class RevisionHistoryExcelRead {
	
	public void readSaveRevisionHistory(Sheet datatypeSheet,int lobId,FeatureListService featureListService) {	
		List<RevisionHistoryEntity> listRevisionHistory = new ArrayList<RevisionHistoryEntity>();		
		//read revision History
		listRevisionHistory = readRevisionHistory(datatypeSheet,lobId);
		//save Revision History
		saveRevisionHistory(listRevisionHistory,featureListService);		
	}
	
	private List<RevisionHistoryEntity> readRevisionHistory(Sheet datatypeSheet,int lobId) {
		List<RevisionHistoryEntity> listRevisionHistory = new ArrayList<RevisionHistoryEntity>();
		RevisionHistoryEntity revision = null;

		try {
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean flag = false;
			boolean checkIndex = true;
			int startingIndex = 0;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				revision = new RevisionHistoryEntity();
				revision.setLobId(lobId);
				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					if (checkIndex && currentCell.getCellTypeEnum() == CellType.STRING
							&& currentCell.getStringCellValue().equalsIgnoreCase("date")) {
						startingIndex = currentCell.getColumnIndex();
						checkIndex = false;break;
					}
					if (flag || currentCell.getColumnIndex() == startingIndex
							&& currentCell.getCellTypeEnum() == CellType.NUMERIC) {
						flag = true;
						if (currentCell.getCellTypeEnum() == CellType.STRING) {
							if (currentCell.getColumnIndex() == startingIndex + 2) {
								revision.setDescription(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 3) {
								revision.setAuthor(currentCell.getStringCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex + 4) {
								revision.setReviewedBy(currentCell.getStringCellValue());
							}

						} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
							if (currentCell.getColumnIndex() == startingIndex) {
								revision.setDate(currentCell.getDateCellValue());
							} else if (currentCell.getColumnIndex() == startingIndex) {
								revision.setVersion(String.valueOf(currentCell.getNumericCellValue()));
							}
						}
					}
				}
				if (flag) {
					listRevisionHistory.add(revision);
					flag = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRevisionHistory;
	}
	private void saveRevisionHistory(List<RevisionHistoryEntity> listRevisionHistory,FeatureListService featureListService) {
		for (RevisionHistoryEntity rv : listRevisionHistory) {			
			featureListService.saveRevisionHistory(rv);
		}
	}	
}
