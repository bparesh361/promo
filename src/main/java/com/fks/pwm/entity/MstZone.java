package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_zone database table.
 * 
 */
@Entity
@Table(name="mst_zone")
@NamedQuery(name="MstZone.findAll", query="SELECT m FROM MstZone m")
public class MstZone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="zone_id")
	private Long zoneId;

	@Column(name="is_blocked")
	private byte isBlocked;

	@Column(name="zone_code")
	private String zoneCode;

	@Column(name="zone_name")
	private String zoneName;

	//bi-directional many-to-one association to MapPromoZone
	@OneToMany(mappedBy="mstZone")
	private List<MapPromoZone> mapPromoZones;

	//bi-directional many-to-one association to MapRoleZone
	@OneToMany(mappedBy="mstZone")
	private List<MapRoleZone> mapRoleZones;

	//bi-directional many-to-one association to MstStore
	@OneToMany(mappedBy="mstZone")
	private List<MstStore> mstStores;

	//bi-directional many-to-one association to TransPromo
	@OneToMany(mappedBy="mstZone")
	private List<TransPromo> transPromos;

	public MstZone() {
	}

	public Long getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

	public byte getIsBlocked() {
		return this.isBlocked;
	}

	public void setIsBlocked(byte isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getZoneCode() {
		return this.zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getZoneName() {
		return this.zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public List<MapPromoZone> getMapPromoZones() {
		return this.mapPromoZones;
	}

	public void setMapPromoZones(List<MapPromoZone> mapPromoZones) {
		this.mapPromoZones = mapPromoZones;
	}

	public MapPromoZone addMapPromoZone(MapPromoZone mapPromoZone) {
		getMapPromoZones().add(mapPromoZone);
		mapPromoZone.setMstZone(this);

		return mapPromoZone;
	}

	public MapPromoZone removeMapPromoZone(MapPromoZone mapPromoZone) {
		getMapPromoZones().remove(mapPromoZone);
		mapPromoZone.setMstZone(null);

		return mapPromoZone;
	}

	public List<MapRoleZone> getMapRoleZones() {
		return this.mapRoleZones;
	}

	public void setMapRoleZones(List<MapRoleZone> mapRoleZones) {
		this.mapRoleZones = mapRoleZones;
	}

	public MapRoleZone addMapRoleZone(MapRoleZone mapRoleZone) {
		getMapRoleZones().add(mapRoleZone);
		mapRoleZone.setMstZone(this);

		return mapRoleZone;
	}

	public MapRoleZone removeMapRoleZone(MapRoleZone mapRoleZone) {
		getMapRoleZones().remove(mapRoleZone);
		mapRoleZone.setMstZone(null);

		return mapRoleZone;
	}

	public List<MstStore> getMstStores() {
		return this.mstStores;
	}

	public void setMstStores(List<MstStore> mstStores) {
		this.mstStores = mstStores;
	}

	public MstStore addMstStore(MstStore mstStore) {
		getMstStores().add(mstStore);
		mstStore.setMstZone(this);

		return mstStore;
	}

	public MstStore removeMstStore(MstStore mstStore) {
		getMstStores().remove(mstStore);
		mstStore.setMstZone(null);

		return mstStore;
	}

	public List<TransPromo> getTransPromos() {
		return this.transPromos;
	}

	public void setTransPromos(List<TransPromo> transPromos) {
		this.transPromos = transPromos;
	}

	public TransPromo addTransPromo(TransPromo transPromo) {
		getTransPromos().add(transPromo);
		transPromo.setMstZone(this);

		return transPromo;
	}

	public TransPromo removeTransPromo(TransPromo transPromo) {
		getTransPromos().remove(transPromo);
		transPromo.setMstZone(null);

		return transPromo;
	}

}