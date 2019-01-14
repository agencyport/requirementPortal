package com.accenture.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.springmvc.cc.DynDisplayTable;
import com.accenture.springmvc.entity.DynDisplayColumnBean;
import com.accenture.springmvc.entity.LobData;
import com.accenture.springmvc.service.LobService;

@Controller
public class DeleteController {
	@Autowired
	private LobService lobService;

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("lobmenu");
		LobData lobData = new LobData();
		StringBuffer data = new StringBuffer();
		data.append(request.getParameter("category") + "%st" + request.getParameter("coverage") + "%st"
				+ request.getParameter("desc"));
		if (request.getParameter("displayId") != null) {
			lobData.setDataId(Long.parseLong(request.getParameter("displayId")));
		}
		if (request.getParameter("lobId") != null) {
			lobData.setLobReferenceId(Long.parseLong(request.getParameter("lobId")));
		}
		lobData.setData(data.toString());
		lobService.saveLobData(lobData);
		List<LobData> listData = lobService.getLobData(1);
		DynDisplayTable displayTable = new DynDisplayTable();
		List<DynDisplayColumnBean> dynDisplayDetails = displayTable.displayColumnBean(listData);
		System.out.println("Size of the dynamic details data :" + dynDisplayDetails.size());
		model.addObject("excelDataDetails", dynDisplayDetails);
		return model;
	}
	
	@RequestMapping(value = "updateDelete", method = RequestMethod.POST)
	public ModelAndView updateDelete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("lobmenu");
		if (request.getParameter("update") != null) {
			String selectededitId[] = request.getParameterValues("checkboxedit");
			model = new ModelAndView("lobedit");
			return update(selectededitId,model);
		} else if (request.getParameter("delete") != null) {
			String selecteddeleteId[] = request.getParameterValues("checkboxdelete");
			model = new ModelAndView("lobmenu");
			return delete(selecteddeleteId,model);
		}
		return model;		
		
	}
	
	@RequestMapping(value = "lobMenu", method = RequestMethod.POST)
	public ModelAndView lobMenu(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("lobmenu");
		List<LobData> listData = lobService.getLobData(1);
		DynDisplayTable displayTable = new DynDisplayTable();
		List<DynDisplayColumnBean> dynDisplayDetails = displayTable.displayColumnBean(listData);
		System.out.println("Size of the dynamic details data :" + dynDisplayDetails.size());
		model.addObject("excelDataDetails", dynDisplayDetails);
		return model;			
	}

	private ModelAndView delete(String[] selectedId,ModelAndView model) {		
		if (selectedId!=null && selectedId.length > 0) {
			List<Long> listDataId = new ArrayList<>();
			for (int i = 0; i < selectedId.length; i++) {
				listDataId.add(Long.parseLong(selectedId[i]));
			}
			lobService.deleteLobData(listDataId);
		}
		List<LobData> listData = lobService.getLobData(1);
		DynDisplayTable displayTable = new DynDisplayTable();
		List<DynDisplayColumnBean> dynDisplayDetails = displayTable.displayColumnBean(listData);
		System.out.println("Size of the dynamic details data :" + dynDisplayDetails.size());
		model.addObject("excelDataDetails", dynDisplayDetails);
		return model;
	}
	private ModelAndView update(String[] selectedId,ModelAndView model) {		
		if (selectedId != null && selectedId.length > 0) {
			DynDisplayColumnBean dynDisplayColumnBean = new DynDisplayColumnBean();
			LobData data = new LobData();
			List<LobData> listData = lobService.getLobData(1);
			for (LobData lobData : listData) {
				if (String.valueOf(lobData.getDataId()).equals(selectedId[0])) {
					data = lobData;
					break;
				}
			}		
		dynDisplayColumnBean.setDisplayId(data.getDataId());
		dynDisplayColumnBean.setDisplayData(data.getData().split("%st"));
		dynDisplayColumnBean.setLobId(data.getLobReferenceId());
		dynDisplayColumnBean.setTitle(data.getData().split("%st"));
		model.addObject("dynDisplayColumnBean", dynDisplayColumnBean);
		}
		return model;
	}

}