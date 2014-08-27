package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_department database table.
 * 
 */
@Entity
@Table(name="mst_department")
@NamedQuery(name="MstDepartment.findAll", query="SELECT m FROM MstDepartment m")
public class MstDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mst_dept_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mstDeptId;

	@Column(name="dept_name")
	private String deptName;

	@Column(name="is_blocked")
	private byte isBlocked;

	//bi-directional many-to-one association to MapUserDepartment
	@OneToMany(mappedBy="mstDepartment")
	private List<MapUserDepartment> mapUserDepartments;

	//bi-directional many-to-one association to MstProposal
	@OneToMany(mappedBy="mstDepartment")
	private List<MstProposal> mstProposals;

	public MstDepartment() {
	}

	public Long getMstDeptId() {
		return this.mstDeptId;
	}

	public void setMstDeptId(Long mstDeptId) {
		this.mstDeptId = mstDeptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public byte getIsBlocked() {
		return this.isBlocked;
	}

	public void setIsBlocked(byte isBlocked) {
		this.isBlocked = isBlocked;
	}

	public List<MapUserDepartment> getMapUserDepartments() {
		return this.mapUserDepartments;
	}

	public void setMapUserDepartments(List<MapUserDepartment> mapUserDepartments) {
		this.mapUserDepartments = mapUserDepartments;
	}

	public MapUserDepartment addMapUserDepartment(MapUserDepartment mapUserDepartment) {
		getMapUserDepartments().add(mapUserDepartment);
		mapUserDepartment.setMstDepartment(this);

		return mapUserDepartment;
	}

	public MapUserDepartment removeMapUserDepartment(MapUserDepartment mapUserDepartment) {
		getMapUserDepartments().remove(mapUserDepartment);
		mapUserDepartment.setMstDepartment(null);

		return mapUserDepartment;
	}

	public List<MstProposal> getMstProposals() {
		return this.mstProposals;
	}

	public void setMstProposals(List<MstProposal> mstProposals) {
		this.mstProposals = mstProposals;
	}

	public MstProposal addMstProposal(MstProposal mstProposal) {
		getMstProposals().add(mstProposal);
		mstProposal.setMstDepartment(this);

		return mstProposal;
	}

	public MstProposal removeMstProposal(MstProposal mstProposal) {
		getMstProposals().remove(mstProposal);
		mstProposal.setMstDepartment(null);

		return mstProposal;
	}

}