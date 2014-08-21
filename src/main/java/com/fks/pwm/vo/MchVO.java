package com.fks.pwm.vo;

public class MchVO {

	private String mcCode;
	private String mcName;
	private String subCategoryName;
	private String categoryName;
	private String location;
	public String getMcCode() {
		return mcCode;
	}
	public void setMcCode(String mcCode) {
		this.mcCode = mcCode;
	}
	public String getMcName() {
		return mcName;
	}
	public void setMcName(String mcName) {
		this.mcName = mcName;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "MchVO [mcCode=" + mcCode + ", mcName=" + mcName
				+ ", subCategoryName=" + subCategoryName + ", categoryName="
				+ categoryName + ", location=" + location + "]";
	}
	
}
