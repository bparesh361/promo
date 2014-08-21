package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the map_module_profile database table.
 * 
 */
@Entity
@Table(name="map_module_profile")
@NamedQuery(name="MapModuleProfile.findAll", query="SELECT m FROM MapModuleProfile m")
public class MapModuleProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_profile_module_id")
	private String mapProfileModuleId;

	//bi-directional many-to-one association to MstModule
	@ManyToOne
	@JoinColumn(name="module_id")
	private MstModule mstModule;

	//bi-directional many-to-one association to MstProfile
	@ManyToOne
	@JoinColumn(name="profile_id")
	private MstProfile mstProfile;

	public MapModuleProfile() {
	}

	public String getMapProfileModuleId() {
		return this.mapProfileModuleId;
	}

	public void setMapProfileModuleId(String mapProfileModuleId) {
		this.mapProfileModuleId = mapProfileModuleId;
	}

	public MstModule getMstModule() {
		return this.mstModule;
	}

	public void setMstModule(MstModule mstModule) {
		this.mstModule = mstModule;
	}

	public MstProfile getMstProfile() {
		return this.mstProfile;
	}

	public void setMstProfile(MstProfile mstProfile) {
		this.mstProfile = mstProfile;
	}

}