package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mst_role database table.
 * 
 */
@Entity
@Table(name="mst_role")
@NamedQuery(name="MstRole.findAll", query="SELECT m FROM MstRole m")
public class MstRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mst_role_id")
	private String mstRoleId;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="is_active")
	private byte isActive;

	@Column(name="role_name")
	private String roleName;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to MapRoleLocation
	@OneToMany(mappedBy="mstRole")
	private List<MapRoleLocation> mapRoleLocations;

	//bi-directional many-to-one association to MapRoleMch
	@OneToMany(mappedBy="mstRole")
	private List<MapRoleMch> mapRoleMches;

	//bi-directional many-to-one association to MapRoleProfile
	@OneToMany(mappedBy="mstRole")
	private List<MapRoleProfile> mapRoleProfiles;

	//bi-directional many-to-one association to MapRoleZone
	@OneToMany(mappedBy="mstRole")
	private List<MapRoleZone> mapRoleZones;

	//bi-directional many-to-one association to MstEmployee
	@OneToMany(mappedBy="mstRole")
	private List<MstEmployee> mstEmployees;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="created_by")
	private MstEmployee mstEmployee1;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="updated_by")
	private MstEmployee mstEmployee2;

	public MstRole() {
	}

	public String getMstRoleId() {
		return this.mstRoleId;
	}

	public void setMstRoleId(String mstRoleId) {
		this.mstRoleId = mstRoleId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<MapRoleLocation> getMapRoleLocations() {
		return this.mapRoleLocations;
	}

	public void setMapRoleLocations(List<MapRoleLocation> mapRoleLocations) {
		this.mapRoleLocations = mapRoleLocations;
	}

	public MapRoleLocation addMapRoleLocation(MapRoleLocation mapRoleLocation) {
		getMapRoleLocations().add(mapRoleLocation);
		mapRoleLocation.setMstRole(this);

		return mapRoleLocation;
	}

	public MapRoleLocation removeMapRoleLocation(MapRoleLocation mapRoleLocation) {
		getMapRoleLocations().remove(mapRoleLocation);
		mapRoleLocation.setMstRole(null);

		return mapRoleLocation;
	}

	public List<MapRoleMch> getMapRoleMches() {
		return this.mapRoleMches;
	}

	public void setMapRoleMches(List<MapRoleMch> mapRoleMches) {
		this.mapRoleMches = mapRoleMches;
	}

	public MapRoleMch addMapRoleMch(MapRoleMch mapRoleMch) {
		getMapRoleMches().add(mapRoleMch);
		mapRoleMch.setMstRole(this);

		return mapRoleMch;
	}

	public MapRoleMch removeMapRoleMch(MapRoleMch mapRoleMch) {
		getMapRoleMches().remove(mapRoleMch);
		mapRoleMch.setMstRole(null);

		return mapRoleMch;
	}

	public List<MapRoleProfile> getMapRoleProfiles() {
		return this.mapRoleProfiles;
	}

	public void setMapRoleProfiles(List<MapRoleProfile> mapRoleProfiles) {
		this.mapRoleProfiles = mapRoleProfiles;
	}

	public MapRoleProfile addMapRoleProfile(MapRoleProfile mapRoleProfile) {
		getMapRoleProfiles().add(mapRoleProfile);
		mapRoleProfile.setMstRole(this);

		return mapRoleProfile;
	}

	public MapRoleProfile removeMapRoleProfile(MapRoleProfile mapRoleProfile) {
		getMapRoleProfiles().remove(mapRoleProfile);
		mapRoleProfile.setMstRole(null);

		return mapRoleProfile;
	}

	public List<MapRoleZone> getMapRoleZones() {
		return this.mapRoleZones;
	}

	public void setMapRoleZones(List<MapRoleZone> mapRoleZones) {
		this.mapRoleZones = mapRoleZones;
	}

	public MapRoleZone addMapRoleZone(MapRoleZone mapRoleZone) {
		getMapRoleZones().add(mapRoleZone);
		mapRoleZone.setMstRole(this);

		return mapRoleZone;
	}

	public MapRoleZone removeMapRoleZone(MapRoleZone mapRoleZone) {
		getMapRoleZones().remove(mapRoleZone);
		mapRoleZone.setMstRole(null);

		return mapRoleZone;
	}

	public List<MstEmployee> getMstEmployees() {
		return this.mstEmployees;
	}

	public void setMstEmployees(List<MstEmployee> mstEmployees) {
		this.mstEmployees = mstEmployees;
	}

	public MstEmployee addMstEmployee(MstEmployee mstEmployee) {
		getMstEmployees().add(mstEmployee);
		mstEmployee.setMstRole(this);

		return mstEmployee;
	}

	public MstEmployee removeMstEmployee(MstEmployee mstEmployee) {
		getMstEmployees().remove(mstEmployee);
		mstEmployee.setMstRole(null);

		return mstEmployee;
	}

	public MstEmployee getMstEmployee1() {
		return this.mstEmployee1;
	}

	public void setMstEmployee1(MstEmployee mstEmployee1) {
		this.mstEmployee1 = mstEmployee1;
	}

	public MstEmployee getMstEmployee2() {
		return this.mstEmployee2;
	}

	public void setMstEmployee2(MstEmployee mstEmployee2) {
		this.mstEmployee2 = mstEmployee2;
	}

}