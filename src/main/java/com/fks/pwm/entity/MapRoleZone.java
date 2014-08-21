package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the map_role_zone database table.
 * 
 */
@Entity
@Table(name="map_role_zone")
@NamedQuery(name="MapRoleZone.findAll", query="SELECT m FROM MapRoleZone m")
public class MapRoleZone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_id")
	private String mapId;

	//bi-directional many-to-one association to MstRole
	@ManyToOne
	@JoinColumn(name="mst_role_id")
	private MstRole mstRole;

	//bi-directional many-to-one association to MstZone
	@ManyToOne
	@JoinColumn(name="zone_id")
	private MstZone mstZone;

	public MapRoleZone() {
	}

	public String getMapId() {
		return this.mapId;
	}

	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	public MstRole getMstRole() {
		return this.mstRole;
	}

	public void setMstRole(MstRole mstRole) {
		this.mstRole = mstRole;
	}

	public MstZone getMstZone() {
		return this.mstZone;
	}

	public void setMstZone(MstZone mstZone) {
		this.mstZone = mstZone;
	}

}