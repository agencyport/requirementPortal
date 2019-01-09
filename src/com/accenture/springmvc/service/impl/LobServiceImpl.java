package com.accenture.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.springmvc.dao.EmployeeDAO;
import com.accenture.springmvc.dao.LobDAO;
import com.accenture.springmvc.entity.Lob;
import com.accenture.springmvc.entity.LobData;
import com.accenture.springmvc.service.LobService;

@Service
@Transactional
public class LobServiceImpl implements LobService {
	@Autowired
	private LobDAO lobDAO;

	@Override
	public void createLob(Lob lob) {
		lobDAO.createLob(lob);
		
	}

	

	@Override
	public void saveLobData(LobData lobData) {
		lobDAO.saveLobData(lobData);
		
	}

	@Override
	public List<LobData> getLobData(long lobData) {
		return lobDAO.getLobData(lobData);
		
	}



	@Override
	public List<Lob> getLobs() {		
		 return lobDAO.getLobs();	
	}	
}
