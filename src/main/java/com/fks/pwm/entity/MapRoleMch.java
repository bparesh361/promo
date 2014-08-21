package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the map_role_mch database table.
 * 
 */
@Entity
@Table(name="map_role_mch")
@NamedQuery(name="MapRoleMch.findAll", query="SELECT m FROM MapRoleMch m")
public class MapRoleMch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_id")
	private String mapId;

	//bi-directional many-to-one association to Mch
	@ManyToOne
	@JoinColumn(name="mc_code")
	private Mch mch;

	//bi-directional many-to-one association to MstRole
	@ManyToOne
	@JoinColumn(name="mst_role_id")
	private MstRole mstRole;

	public MapRoleMch() {
	}

	public String getMapId() {
		return this.mapId;
	}

	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	public Mch getMch() {
		return this.mch;
	}

	public void setMch(Mch mch) {
		this.mch = mch;
	}

	public MstRole getMstRole() {
		return this.mstRole;
	}

	public void setMstRole(MstRole mstRole) {
		this.mstRole = mstRole;
	}

}