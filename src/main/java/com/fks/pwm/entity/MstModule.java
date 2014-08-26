package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_module database table.
 * 
 */
@Entity
@Table(name="mst_module")
@NamedQuery(name="MstModule.findAll", query="SELECT m FROM MstModule m")
public class MstModule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="module_id")
	private Long moduleId;

	@Column(name="is_displayed")
	private byte isDisplayed;

	@Column(name="module_desc")
	private String moduleDesc;

	@Column(name="module_name")
	private String moduleName;

	//bi-directional many-to-one association to MapModuleProfile
	@OneToMany(mappedBy="mstModule")
	private List<MapModuleProfile> mapModuleProfiles;

	public MstModule() {
	}

	public Long getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public byte getIsDisplayed() {
		return this.isDisplayed;
	}

	public void setIsDisplayed(byte isDisplayed) {
		this.isDisplayed = isDisplayed;
	}

	public String getModuleDesc() {
		return this.moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<MapModuleProfile> getMapModuleProfiles() {
		return this.mapModuleProfiles;
	}

	public void setMapModuleProfiles(List<MapModuleProfile> mapModuleProfiles) {
		this.mapModuleProfiles = mapModuleProfiles;
	}

	public MapModuleProfile addMapModuleProfile(MapModuleProfile mapModuleProfile) {
		getMapModuleProfiles().add(mapModuleProfile);
		mapModuleProfile.setMstModule(this);

		return mapModuleProfile;
	}

	public MapModuleProfile removeMapModuleProfile(MapModuleProfile mapModuleProfile) {
		getMapModuleProfiles().remove(mapModuleProfile);
		mapModuleProfile.setMstModule(null);

		return mapModuleProfile;
	}

}