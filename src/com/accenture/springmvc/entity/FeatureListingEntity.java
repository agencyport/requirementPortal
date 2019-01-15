package com.accenture.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "FeatureListing")
public class FeatureListingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int featureListId;
	@Column
	private int lobId;
	@Column
	private int featureListCLSId;
	@Column
	private String pageName;
	@Column
	private String featurefunction;
	@Column
	private String subFunction;
	@Column
	private String fieldName;
	@Column(length = 65535, columnDefinition = "text")
	private String functionDesc;
	@Column
	private String mandatory;
	@Column(length = 65535, columnDefinition = "text")
	private String businessImapact;
	@Column
	private String intgFunct;
	@Column(length = 65535, columnDefinition = "text")
	private String  funPtValidation;
	@Column
	private String intgSystem;
	@Column
	private String endorse;
	@Column
	private String reneww;
	@Column
	private String cancel;
	@Column
	private String reInstate;
	@Column
	private String reWrite;
	public int getFeatureListId() {
		return featureListId;
	}
	public void setFeatureListId(int featureListId) {
		this.featureListId = featureListId;
	}
	public int getLobId() {
		return lobId;
	}
	public void setLobId(int lobId) {
		this.lobId = lobId;
	}
	public int getFeatureListCLSId() {
		return featureListCLSId;
	}
	public void setFeatureListCLSId(int featureListCLSId) {
		this.featureListCLSId = featureListCLSId;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	public String getFeaturefunction() {
		return featurefunction;
	}
	public void setFeaturefunction(String featurefunction) {
		this.featurefunction = featurefunction;
	}
	public String getSubFunction() {
		return subFunction;
	}
	public void setSubFunction(String subFunction) {
		this.subFunction = subFunction;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFunctionDesc() {
		return functionDesc;
	}
	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}
	public String getMandatory() {
		return mandatory;
	}
	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}
	public String getBusinessImapact() {
		return businessImapact;
	}
	public void setBusinessImapact(String businessImapact) {
		this.businessImapact = businessImapact;
	}
	public String getIntgFunct() {
		return intgFunct;
	}
	public void setIntgFunct(String intgFunct) {
		this.intgFunct = intgFunct;
	}
	
	public String getFunPtValidation() {
		return funPtValidation;
	}
	public void setFunPtValidation(String funPtValidation) {
		this.funPtValidation = funPtValidation;
	}
	public String getIntgSystem() {
		return intgSystem;
	}
	public void setIntgSystem(String intgSystem) {
		this.intgSystem = intgSystem;
	}
	public String getEndorse() {
		return endorse;
	}
	public void setEndorse(String endorse) {
		this.endorse = endorse;
	}
	public String getReneww() {
		return reneww;
	}
	public void setReneww(String reneww) {
		this.reneww = reneww;
	}
	public String getCancel() {
		return cancel;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	public String getReInstate() {
		return reInstate;
	}
	public void setReInstate(String reInstate) {
		this.reInstate = reInstate;
	}
	public String getReWrite() {
		return reWrite;
	}
	public void setReWrite(String reWrite) {
		this.reWrite = reWrite;
	}
	

}
