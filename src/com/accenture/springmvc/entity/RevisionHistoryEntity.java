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
	private int revisionHistoryId;
	@Column
	private int lobId;
	@Column
	private Date date;
	@Column
	private String Version;
	@Column
	private String Description;
	@Column
	private String author;
	@Column
	private String reviewedBy;

	

	public int getLobId() {
		return lobId;
	}

	public void setLobId(int lobId) {
		this.lobId = lobId;
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

	public int getRevisionHistoryId() {
		return revisionHistoryId;
	}

	public void setRevisionHistoryId(int revisionHistoryId) {
		this.revisionHistoryId = revisionHistoryId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	

}
