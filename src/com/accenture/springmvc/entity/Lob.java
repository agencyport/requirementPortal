package com.accenture.springmvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lob")
public class Lob implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long lobId;
	@Column
	public String lobName;

	public long getId() {
		return lobId;
	}

	public void setId(long id) {
		this.lobId = id;
	}

	public String getLobName() {
		return lobName;
	}

	public void setLobName(String lobName) {
		this.lobName = lobName;
	}

	
	
}