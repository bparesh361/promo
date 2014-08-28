package com.fks.pwm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mapId;

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

	public Long getMapId() {
		return this.mapId;
	}

	public void setMapId(Long mapId) {
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