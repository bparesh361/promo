package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_location database table.
 * 
 */
@Entity
@Table(name="mst_location")
@NamedQuery(name="MstLocation.findAll", query="SELECT m FROM MstLocation m")
public class MstLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="location_id")
	private String locationId;

	@Column(name="location_name")
	private String locationName;

	//bi-directional many-to-one association to MapRoleLocation
	@OneToMany(mappedBy="mstLocation")
	private List<MapRoleLocation> mapRoleLocations;

	//bi-directional many-to-one association to Mch
	@OneToMany(mappedBy="mstLocation")
	private List<Mch> mches;

	//bi-directional many-to-one association to MstStore
	@OneToMany(mappedBy="mstLocation")
	private List<MstStore> mstStores;

	public MstLocation() {
	}

	public String getLocationId() {
		return this.locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public List<MapRoleLocation> getMapRoleLocations() {
		return this.mapRoleLocations;
	}

	public void setMapRoleLocations(List<MapRoleLocation> mapRoleLocations) {
		this.mapRoleLocations = mapRoleLocations;
	}

	public MapRoleLocation addMapRoleLocation(MapRoleLocation mapRoleLocation) {
		getMapRoleLocations().add(mapRoleLocation);
		mapRoleLocation.setMstLocation(this);

		return mapRoleLocation;
	}

	public MapRoleLocation removeMapRoleLocation(MapRoleLocation mapRoleLocation) {
		getMapRoleLocations().remove(mapRoleLocation);
		mapRoleLocation.setMstLocation(null);

		return mapRoleLocation;
	}

	public List<Mch> getMches() {
		return this.mches;
	}

	public void setMches(List<Mch> mches) {
		this.mches = mches;
	}

	public Mch addMch(Mch mch) {
		getMches().add(mch);
		mch.setMstLocation(this);

		return mch;
	}

	public Mch removeMch(Mch mch) {
		getMches().remove(mch);
		mch.setMstLocation(null);

		return mch;
	}

	public List<MstStore> getMstStores() {
		return this.mstStores;
	}

	public void setMstStores(List<MstStore> mstStores) {
		this.mstStores = mstStores;
	}

	public MstStore addMstStore(MstStore mstStore) {
		getMstStores().add(mstStore);
		mstStore.setMstLocation(this);

		return mstStore;
	}

	public MstStore removeMstStore(MstStore mstStore) {
		getMstStores().remove(mstStore);
		mstStore.setMstLocation(null);

		return mstStore;
	}

}