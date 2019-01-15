package com.accenture.springmvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RevisionHistory")
public class RevisionHistoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int RevisionHistoryID;
	@Column
	private int lobId;
	@Column
	private Date date;
	@Column
	private String Version;
	@Column
	private String Description;
	@Column
	private String Author;
	@Column
	private String ReviewedBy;

	public int getRevisionHistoryID() {
		return RevisionHistoryID;
	}

	public void setRevisionHistoryID(int revisionHistoryID) {
		RevisionHistoryID = revisionHistoryID;
	}

	public int getLobId() {
		return lobId;
	}

	public void setLobId(int lobId) {
		lobId = lobId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getReviewedBy() {
		return ReviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		ReviewedBy = reviewedBy;
	}

}
