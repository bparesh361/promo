package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the map_role_location database table.
 * 
 */
@Entity
@Table(name="map_role_location")
@NamedQuery(name="MapRoleLocation.findAll", query="SELECT m FROM MapRoleLocation m")
public class MapRoleLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_id")
	private String mapId;

	//bi-directional many-to-one association to MstLocation
	@ManyToOne
	@JoinColumn(name="location_id")
	private MstLocation mstLocation;

	//bi-directional many-to-one association to MstRole
	@ManyToOne
	@JoinColumn(name="mst_role_id")
	private MstRole mstRole;

	public MapRoleLocation() {
	}

	public String getMapId() {
		return this.mapId;
	}

	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	public MstLocation getMstLocation() {
		return this.mstLocation;
	}

	public void setMstLocation(MstLocation mstLocation) {
		this.mstLocation = mstLocation;
	}

	public MstRole getMstRole() {
		return this.mstRole;
	}

	public void setMstRole(MstRole mstRole) {
		this.mstRole = mstRole;
	}

}