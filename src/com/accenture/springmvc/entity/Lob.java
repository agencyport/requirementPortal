package com.accenture.springmvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lob")
public class Lob implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int lobId;
	@Column
	public String lobName;
	

	public int getLobId() {
		return lobId;
	}

	public void setLobId(int lobId) {
		this.lobId = lobId;
	}

	public String getLobName() {
		return lobName;
	}

	public void setLobName(String lobName) {
		this.lobName = lobName;
	}

	
	
}