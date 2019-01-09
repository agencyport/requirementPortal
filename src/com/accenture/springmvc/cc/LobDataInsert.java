package com.accenture.springmvc.cc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.springmvc.entity.ExcelData;
import com.accenture.springmvc.entity.LobData;
import com.accenture.springmvc.service.LobService;

public class LobDataInsert {
	
	@Autowired
	private static LobService lobService;
	
public static void saveData(List<String[]> list) throws IOException {
	
	//List<ExcelData> listDatas = new ArrayList<>();
	//ApachePOIExcelRead.readFile(listDatas,file1);			  
   // XMLWriterDOM.write(listDatas);
    /*File file2 = new File("rules.xml");   
    byte[] fileContent = null;
    try {
    fileContent = FileUtils.readFileToByteArray(file2);
    } catch (IOException e) {
    throw new IOException("Unable to convert file to byte array. " + e.getMessage());
    }*/
	LobData lobData;
	for(String[] str:list){
		System.out.println("STR Array :" +str);
		lobData = new LobData();
		lobData.setData("abc");
		lobData.setLobReferenceId(1);
		lobService.saveLobData(lobData);
	}
    
    
}
}
