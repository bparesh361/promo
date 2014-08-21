package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the map_role_profile database table.
 * 
 */
@Entity
@Table(name="map_role_profile")
@NamedQuery(name="MapRoleProfile.findAll", query="SELECT m FROM MapRoleProfile m")
public class MapRoleProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_id")
	private String mapId;

	//bi-directional many-to-one association to MstProfile
	@ManyToOne
	@JoinColumn(name="profile_id")
	private MstProfile mstProfile;

	//bi-directional many-to-one association to MstRole
	@ManyToOne
	@JoinColumn(name="mst_role_id")
	private MstRole mstRole;

	public MapRoleProfile() {
	}

	public String getMapId() {
		return this.mapId;
	}

	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	public MstProfile getMstProfile() {
		return this.mstProfile;
	}

	public void setMstProfile(MstProfile mstProfile) {
		this.mstProfile = mstProfile;
	}

	public MstRole getMstRole() {
		return this.mstRole;
	}

	public void setMstRole(MstRole mstRole) {
		this.mstRole = mstRole;
	}

}