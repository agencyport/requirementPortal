package com.accenture.springmvc.entity;

public class DynDisplayColumnBean {
	private String[] displayData;
	private int lobId;
	private int displayId;
	private String[] title;
	
	public String[] getDisplayData() {
		return displayData;
	}
	public void setDisplayData(String[] displayData) {
		this.displayData = displayData;
	}
	public long getLobId() {
		return lobId;
	}
	public void setLobId(int lobId) {
		this.lobId = lobId;
	}
	public long getDisplayId() {
		return displayId;
	}
	public void setDisplayId(int displayId) {
		this.displayId = displayId;
	}
	public String[] getTitle() {
		return title;
	}
	public void setTitle(String[] title) {
		this.title = title;
	}	
}
