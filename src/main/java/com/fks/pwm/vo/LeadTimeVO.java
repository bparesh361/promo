package com.fks.pwm.vo;

public class LeadTimeVO {

	private Long id;
	private String L1;
	private String L2;
	private String L5;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getL1() {
		return L1;
	}
	public void setL1(String l1) {
		L1 = l1;
	}
	public String getL2() {
		return L2;
	}
	public void setL2(String l2) {
		L2 = l2;
	}
	public String getL5() {
		return L5;
	}
	public void setL5(String l5) {
		L5 = l5;
	}
	@Override
	public String toString() {
		return "LeadTimeVO [id=" + id + ", L1=" + L1 + ", L2=" + L2 + ", L5="
				+ L5 + "]";
	}
	
	
	
	
}
