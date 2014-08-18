package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_set database table.
 * 
 */
@Entity
@Table(name="mst_set")
@NamedQuery(name="MstSet.findAll", query="SELECT m FROM MstSet m")
public class MstSet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="set_id")
	private String setId;

	@Column(name="set_desc")
	private String setDesc;

	public MstSet() {
	}

	public String getSetId() {
		return this.setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}

	public String getSetDesc() {
		return this.setDesc;
	}

	public void setSetDesc(String setDesc) {
		this.setDesc = setDesc;
	}

}