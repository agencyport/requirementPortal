package com.accenture.springmvc.cc;

import java.util.ArrayList;
import java.util.List;

import com.accenture.springmvc.entity.DynDisplayColumnBean;
import com.accenture.springmvc.entity.LobData;

public class DynDisplayTable {
	public List<DynDisplayColumnBean> displayColumnBean(List<LobData> listdata) {
		List<DynDisplayColumnBean> dynDisplayDetails = new ArrayList<DynDisplayColumnBean>();
		if (listdata != null) {
			DynDisplayColumnBean dynDisplayColumnBean;
			LobData lobdata;
			for (int i = 0; i < listdata.size(); i++) {
				lobdata = new LobData();
				dynDisplayColumnBean = new DynDisplayColumnBean();
				dynDisplayColumnBean.setDisplayId(((LobData) listdata.get(i)).getDataId());
				dynDisplayColumnBean.setDisplayData(((LobData) listdata.get(i)).getData().split("%st"));
				dynDisplayColumnBean.setLobId(((LobData) listdata.get(i)).getLobReferenceId());
				dynDisplayColumnBean.setTitle(((LobData) listdata.get(0)).getData().split("%st"));
				dynDisplayDetails.add(dynDisplayColumnBean);
			}
		}
		return dynDisplayDetails;
	}
}
