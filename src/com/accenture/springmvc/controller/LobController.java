package com.accenture.springmvc.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.springmvc.entity.DynDisplayColumnBean;
import com.accenture.springmvc.entity.ExcelData;
import com.accenture.springmvc.entity.Lob;
import com.accenture.springmvc.entity.LobData;
import com.accenture.springmvc.service.LobService;


@Controller
public class LobController {
	@Autowired
	private LobService lobService;

    @Autowired
    @Qualifier("lobValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		Lob lob = new Lob();
		model.addAttribute("lob", lob);
		initModelList(model);
		return "lob";
	}
	@RequestMapping(value = "lob", method = RequestMethod.POST)
	public String submitForm(Model model, @Validated Lob lob, BindingResult result) {
		model.addAttribute("lob", lob);
		String returnVal = "successlob";
		if("Workers Compensation".equals(lob.getLobName())){
			//initExcelDatas(model);
			List<LobData> listData= lobService.getLobData(1);
	    	List<DynDisplayColumnBean> dynDisplayDetails = new ArrayList<DynDisplayColumnBean>();
	    	DynDisplayColumnBean dynDisplayColumnBean;	 
	    	LobData lobdata;
	    	for(int i=0;i<listData.size();i++){
	    		lobdata = new LobData();
	    		dynDisplayColumnBean = new DynDisplayColumnBean();
	    		dynDisplayColumnBean.setDisplayId(((LobData)listData.get(i)).getDataId());
	    		dynDisplayColumnBean.setDisplayData(((LobData)listData.get(i)).getData().split("%st"));
	    		dynDisplayColumnBean.setLobId(((LobData)listData.get(i)).getLobReferenceId());
	    		dynDisplayColumnBean.setTitle(((LobData)listData.get(0)).getData().split("%st"));
	    		dynDisplayDetails.add(dynDisplayColumnBean);
	    	}
	    	System.out.println("Size of the dynamic details data :" +dynDisplayDetails.size());
			model.addAttribute("excelDataDetails", dynDisplayDetails);
			return "lobmenu";
		}
		
		if(result.hasErrors()) {
			initModelList(model);
			returnVal = "lob";
		} else {
			model.addAttribute("lob", lob);
		}		
		return returnVal;
	}
	@RequestMapping(value = "lobcreation", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute Lob lob) {
		lobService.createLob(lob);
		lob.setLobName(null);
		return new ModelAndView("home");
	}
	private void initModelList(Model model) {
		List<Lob> lobList = lobService.getLobs();
		List<String> lobs = new ArrayList<>();
		for (Lob  lob: lobList) {
			lobs.add(lob.getLobName());
		}
		model.addAttribute("lobs", lobs);
	}
	
	private void initExcelDatas(Model model) {
		List<ExcelData> listDatas = new ArrayList<>();
		String FILE_NAME = "C:\\Users\\santosh.bw.kumar\\Documents\\Req\\RequirementPortal\\RequirementPortal\\MyExcel.xls";
		File file2 = new File(FILE_NAME);
		//ApachePOIExcelRead.readFile(listDatas,file2);
		model.addAttribute("excelDatas", listDatas);
	}
	
}