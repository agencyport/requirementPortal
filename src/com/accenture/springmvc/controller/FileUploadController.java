package com.accenture.springmvc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.springmvc.cc.ApachePOIExcelRead;
import com.accenture.springmvc.cc.DynDisplayTable;
import com.accenture.springmvc.cc.LobDataInsert;
import com.accenture.springmvc.cc.XMLWriterDOM;
import com.accenture.springmvc.entity.DynDisplayColumnBean;
import com.accenture.springmvc.entity.ExcelData;
import com.accenture.springmvc.entity.LobData;
import com.accenture.springmvc.service.LobService;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {
	@Autowired
	private LobService lobService;

	/**
	 * Upload single file using Spring Controller
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody ModelAndView uploadFileHandler(@RequestParam("file") MultipartFile fileUpload)
			throws IOException {
		ModelAndView model = new ModelAndView("lobmenu");
		String fileLocation;

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
			List<String> list = ApachePOIExcelRead.readFile(serverFile);
			System.out.println("Size of the List :" + list.size());
			for (int i = 0; i < list.size(); i++) {
				System.out.println("Data :" + list.get(i));
			}
			LobData lobData = null;
			for (String str : list) {
				System.out.println("STR Array :" + str);
				lobData = new LobData();
				lobData.setData(str);
				lobData.setLobReferenceId(1);
				lobService.saveLobData(lobData);
			}
			List<LobData> listData = lobService.getLobData(1);
			List<DynDisplayColumnBean> dynDisplayDetails = new ArrayList<DynDisplayColumnBean>();
			DynDisplayTable displayTable = new DynDisplayTable();
			dynDisplayDetails = displayTable.displayColumnBean(listData);
			System.out.println("Size of the dynamic details data :" + dynDisplayDetails.size());
			model.addObject("workingDir", System.getProperty("user.dir"));
			model.addObject("excelDataDetails", dynDisplayDetails);

		}
		return model;
	}

}
