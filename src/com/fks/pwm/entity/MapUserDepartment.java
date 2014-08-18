package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the map_user_department database table.
 * 
 */
@Entity
@Table(name="map_user_department")
@NamedQuery(name="MapUserDepartment.findAll", query="SELECT m FROM MapUserDepartment m")
public class MapUserDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_user_dept_id")
	private String mapUserDeptId;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private MstEmployee mstEmployee;

	//bi-directional many-to-one association to MstDepartment
	@ManyToOne
	@JoinColumn(name="mst_dept_id")
	private MstDepartment mstDepartment;

	public MapUserDepartment() {
	}

	public String getMapUserDeptId() {
		return this.mapUserDeptId;
	}

	public void setMapUserDeptId(String mapUserDeptId) {
		this.mapUserDeptId = mapUserDeptId;
	}

	public MstEmployee getMstEmployee() {
		return this.mstEmployee;
	}

	public void setMstEmployee(MstEmployee mstEmployee) {
		this.mstEmployee = mstEmployee;
	}

	public MstDepartment getMstDepartment() {
		return this.mstDepartment;
	}

	public void setMstDepartment(MstDepartment mstDepartment) {
		this.mstDepartment = mstDepartment;
	}

}