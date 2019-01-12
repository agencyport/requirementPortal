package com.accenture.springmvc.service;

import java.util.List;

import com.accenture.springmvc.entity.Lob;
import com.accenture.springmvc.entity.LobData;

public interface LobService {
	public void createLob(Lob lob);
	public List<Lob> getLobs();
	public void saveLobData(LobData lobData);
	public List<LobData> getLobData(long lobData);	
	public void deleteLobData(List<Long> listDataId);
	
}
