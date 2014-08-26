package com.fks.pwm.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the map_user_MCH_F3 database table.
 * 
 */
@Entity
@Table(name="map_user_MCH_F3")
//@NamedQuery(name="Map_user_MCH_F3.findAll", query="SELECT m FROM Map_user_MCH_F3 m")
public class Map_user_MCH_F3 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String map_user_MCH_F3_id;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private MstEmployee mstEmployee;

	//bi-directional many-to-one association to Mch
	@ManyToOne
	@JoinColumn(name="mc_code")
	private Mch mch;

	public Map_user_MCH_F3() {
	}

	public String getMap_user_MCH_F3_id() {
		return this.map_user_MCH_F3_id;
	}

	public void setMap_user_MCH_F3_id(String map_user_MCH_F3_id) {
		this.map_user_MCH_F3_id = map_user_MCH_F3_id;
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