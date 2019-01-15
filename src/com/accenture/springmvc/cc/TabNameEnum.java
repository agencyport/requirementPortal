package com.accenture.springmvc.cc;

public enum TabNameEnum {
	RevisionHistory("Revision History"),
	FeatureListing("WC Feature Listing"),
	CoverageDetails("Coverage Details"),
	RuleDetails("Rule Details");
	 private String name;
	 
	 TabNameEnum(String name) {
	        this.name = name;
	    }
	 
	    public String getName() {
	        return name;
	    }
}
