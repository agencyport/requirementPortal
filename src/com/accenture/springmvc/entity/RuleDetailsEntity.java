package com.accenture.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RuleDetails")
public class RuleDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ruleId;
	@Column
	private int lobId;
	@Column
	private String category;
	@Column
	private String coverageAppl;
	@Column(length = 65535, columnDefinition = "text")
	private String ruleDesc;

	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	public int getLobId() {
		return lobId;
	}

	public void setLobId(int lobId) {
		this.lobId = lobId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCoverageAppl() {
		return coverageAppl;
	}

	public void setCoverageAppl(String coverageAppl) {
		this.coverageAppl = coverageAppl;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}
}
