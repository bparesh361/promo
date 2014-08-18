package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_lead_time database table.
 * 
 */
@Entity
@Table(name="mst_lead_time")
@NamedQuery(name="MstLeadTime.findAll", query="SELECT m FROM MstLeadTime m")
public class MstLeadTime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="mst_lead_time__desc")
	private String mstLeadTimeDesc;

	private int value;

	public MstLeadTime() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMstLeadTimeDesc() {
		return this.mstLeadTimeDesc;
	}

	public void setMstLeadTimeDesc(String mstLeadTimeDesc) {
		this.mstLeadTimeDesc = mstLeadTimeDesc;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}