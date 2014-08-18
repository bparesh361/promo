package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_profile database table.
 * 
 */
@Entity
@Table(name="mst_profile")
@NamedQuery(name="MstProfile.findAll", query="SELECT m FROM MstProfile m")
public class MstProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="profile_id")
	private String profileId;

	@Column(name="level_access")
	private String levelAccess;

	@Column(name="profile_name")
	private String profileName;

	//bi-directional many-to-one association to MapModuleProfile
	@OneToMany(mappedBy="mstProfile")
	private List<MapModuleProfile> mapModuleProfiles;

	//bi-directional many-to-one association to MapRoleProfile
	@OneToMany(mappedBy="mstProfile")
	private List<MapRoleProfile> mapRoleProfiles;

	public MstProfile() {
	}

	public String getProfileId() {
		return this.profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getLevelAccess() {
		return this.levelAccess;
	}

	public void setLevelAccess(String levelAccess) {
		this.levelAccess = levelAccess;
	}

	public String getProfileName() {
		return this.profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public List<MapModuleProfile> getMapModuleProfiles() {
		return this.mapModuleProfiles;
	}

	public void setMapModuleProfiles(List<MapModuleProfile> mapModuleProfiles) {
		this.mapModuleProfiles = mapModuleProfiles;
	}

	public MapModuleProfile addMapModuleProfile(MapModuleProfile mapModuleProfile) {
		getMapModuleProfiles().add(mapModuleProfile);
		mapModuleProfile.setMstProfile(this);

		return mapModuleProfile;
	}

	public MapModuleProfile removeMapModuleProfile(MapModuleProfile mapModuleProfile) {
		getMapModuleProfiles().remove(mapModuleProfile);
		mapModuleProfile.setMstProfile(null);

		return mapModuleProfile;
	}

	public List<MapRoleProfile> getMapRoleProfiles() {
		return this.mapRoleProfiles;
	}

	public void setMapRoleProfiles(List<MapRoleProfile> mapRoleProfiles) {
		this.mapRoleProfiles = mapRoleProfiles;
	}

	public MapRoleProfile addMapRoleProfile(MapRoleProfile mapRoleProfile) {
		getMapRoleProfiles().add(mapRoleProfile);
		mapRoleProfile.setMstProfile(this);

		return mapRoleProfile;
	}

	public MapRoleProfile removeMapRoleProfile(MapRoleProfile mapRoleProfile) {
		getMapRoleProfiles().remove(mapRoleProfile);
		mapRoleProfile.setMstProfile(null);

		return mapRoleProfile;
	}

}