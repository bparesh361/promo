package com.fks.pwm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the map_user_MCH_F1 database table.
 * 
 */
@Entity
@Table(name="map_user_MCH_F1")
//@NamedQuery(name="map_user_mch_f1.findAll", query="SELECT m FROM map_user_mch_f1 m")
public class Map_user_MCH_F1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long map_user_MCH_F1_id;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private MstEmployee mstEmployee;

	//bi-directional many-to-one association to Mch
	@ManyToOne
	@JoinColumn(name="mc_code")
	private Mch mch;

	public Map_user_MCH_F1() {
	}

	public Long getMap_user_MCH_F1_id() {
		return this.map_user_MCH_F1_id;
	}

	public void setMap_user_MCH_F1_id(Long map_user_MCH_F1_id) {
		this.map_user_MCH_F1_id = map_user_MCH_F1_id;
	}

	public MstEmployee getMstEmployee() {
		return this.mstEmployee;
	}

	public void setMstEmployee(MstEmployee mstEmployee) {
		this.mstEmployee = mstEmployee;
	}

	public Mch getMch() {
		return this.mch;
	}

	public void setMch(Mch mch) {
		this.mch = mch;
	}

}