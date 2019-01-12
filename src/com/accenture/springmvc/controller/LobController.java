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

import com.accenture.springmvc.cc.DynDisplayTable;
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

	@RequestMapping(value = "lob", method = RequestMethod.GET)
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
		if ("Workers Compensation".equals(lob.getLobName())) {
			// initExcelDatas(model);
			List<LobData> listData = lobService.getLobData(1);
			DynDisplayTable displayTable = new DynDisplayTable();
			List<DynDisplayColumnBean> dynDisplayDetails = displayTable.displayColumnBean(listData);
			System.out.println("Size of the dynamic details data :" + dynDisplayDetails.size());
			model.addAttribute("excelDataDetails", dynDisplayDetails);
			model.addAttribute("workingDir", System.getProperty("user.dir"));
			return "lobmenu";
		}

		if (result.hasErrors()) {
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
		for (Lob lob : lobList) {
			lobs.add(lob.getLobName());
		}
		model.addAttribute("lobs", lobs);
	}

}