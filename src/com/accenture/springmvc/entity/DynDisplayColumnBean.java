package com.accenture.springmvc.entity;

public class DynDisplayColumnBean {
	private String[] displayData;
	private long lobId;
	private long displayId;
	private String[] title;
	private boolean editableCheckbox;
	public boolean getEditableCheckbox() {
		return editableCheckbox;
	}
	public void setEditableCheckbox(boolean editableCheckbox) {
		this.editableCheckbox = editableCheckbox;
	}
	public String[] getDisplayData() {
		return displayData;
	}
	public void setDisplayData(String[] displayData) {
		this.displayData = displayData;
	}
	public long getLobId() {
		return lobId;
	}
	public void setLobId(long lobId) {
		this.lobId = lobId;
	}
	public long getDisplayId() {
		return displayId;
	}
	public void setDisplayId(long displayId) {
		this.displayId = displayId;
	}
	public String[] getTitle() {
		return title;
	}
	public void setTitle(String[] title) {
		this.title = title;
	}	
}
