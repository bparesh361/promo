package com.fks.pwm.vo;

public class UserVO {
	
	private String empCode;
	private String empName;
	private String empMgr;
	private String empContact;
	private String empEmail;
	private String siteType;
	private String hoSelect;
	private String storeSelect;
	private String zoneSelect;
	private Long role;
	
	
	public String getEmpCode() {
		return empCode;
	}


	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpMgr() {
		return empMgr;
	}


	public void setEmpMgr(String empMgr) {
		this.empMgr = empMgr;
	}


	public String getEmpContact() {
		return empContact;
	}


	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}


	public String getEmpEmail() {
		return empEmail;
	}


	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}


	public String getSiteType() {
		return siteType;
	}


	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}


	public String getHoSelect() {
		return hoSelect;
	}


	public void setHoSelect(String hoSelect) {
		this.hoSelect = hoSelect;
	}


	public String getStoreSelect() {
		return storeSelect;
	}


	public void setStoreSelect(String storeSelect) {
		this.storeSelect = storeSelect;
	}


	public String getZoneSelect() {
		return zoneSelect;
	}


	public void setZoneSelect(String zoneSelect) {
		this.zoneSelect = zoneSelect;
	}


	public Long getRole() {
		return role;
	}


	public void setRole(Long role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "UserVO [empCode=" + empCode + ", empName=" + empName
				+ ", empMgr=" + empMgr + ", empContact=" + empContact
				+ ", empEmail=" + empEmail + ", siteType=" + siteType
				+ ", hoSelect=" + hoSelect + ", storeSelect=" + storeSelect
				+ ", zoneSelect=" + zoneSelect + ", role=" + role + "]";
	}
	
	


	
	
	
}
