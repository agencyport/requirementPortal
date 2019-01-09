package com.accenture.springmvc.cc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOIExcelRead {

	public static  List<String> readFile(File file ) {
    	   List<String> list = new ArrayList<String>();

        try {
            FileInputStream excelFile = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            String []arr = null;
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                int i= 1;
                String excelMessage = "";
                arr = new String[currentRow.getLastCellNum()];
                while (cellIterator.hasNext()) {                	 

                 Cell currentCell = cellIterator.next();
                    
                 if(currentCell.getCellTypeEnum() == CellType.BLANK){
                	 arr[i]= "Not Applicable";
                 }else if(currentCell.getCellTypeEnum() == CellType.STRING){
                	 arr[i]= currentCell.getStringCellValue();
                 }else if(currentCell.getCellTypeEnum() == CellType.BOOLEAN){
                	 arr[i]= Boolean.toString(currentCell.getBooleanCellValue());
                 }else if(currentCell.getCellTypeEnum() == CellType.NUMERIC){
                	 arr[i]= Double.toString(currentCell.getNumericCellValue());
                 }

                 System.out.println("CELL: " + i + " --> " + arr[i]);                   
                  excelMessage += arr[i] + "%st";
                    	
                 }
                list.add(excelMessage);
                    i++;
                }
                
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        return list;
    }
}
