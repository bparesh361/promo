package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mst_store database table.
 * 
 */
@Entity
@Table(name="mst_store")
@NamedQuery(name="MstStore.findAll", query="SELECT m FROM MstStore m")
public class MstStore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mst_store_id")
	private String mstStoreId;

	private String city;

	@Column(name="format_name")
	private String formatName;

	@Column(name="is_blocked")
	private byte isBlocked;

	@Column(name="region_name")
	private String regionName;

	@Column(name="site_description")
	private String siteDescription;

	private String state;

	@Column(name="store_class")
	private String storeClass;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to MapPromoStore
	@OneToMany(mappedBy="mstStore")
	private List<MapPromoStore> mapPromoStores;

	//bi-directional many-to-one association to MstEmployee
	@OneToMany(mappedBy="mstStore")
	private List<MstEmployee> mstEmployees;

	//bi-directional many-to-one association to MstLocation
	@ManyToOne
	@JoinColumn(name="mst_location_id")
	private MstLocation mstLocation;

	//bi-directional many-to-one association to MstZone
	@ManyToOne
	@JoinColumn(name="mst_zone_id")
	private MstZone mstZone;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="created_by")
	private MstEmployee mstEmployee;

	public MstStore() {
	}

	public String getMstStoreId() {
		return this.mstStoreId;
	}

	public void setMstStoreId(String mstStoreId) {
		this.mstStoreId = mstStoreId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFormatName() {
		return this.formatName;
	}

	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}

	public byte getIsBlocked() {
		return this.isBlocked;
	}

	public void setIsBlocked(byte isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getSiteDescription() {
		return this.siteDescription;
	}

	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStoreClass() {
		return this.storeClass;
	}

	public void setStoreClass(String storeClass) {
		this.storeClass = storeClass;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<MapPromoStore> getMapPromoStores() {
		return this.mapPromoStores;
	}

	public void setMapPromoStores(List<MapPromoStore> mapPromoStores) {
		this.mapPromoStores = mapPromoStores;
	}

	public MapPromoStore addMapPromoStore(MapPromoStore mapPromoStore) {
		getMapPromoStores().add(mapPromoStore);
		mapPromoStore.setMstStore(this);

		return mapPromoStore;
	}

	public MapPromoStore removeMapPromoStore(MapPromoStore mapPromoStore) {
		getMapPromoStores().remove(mapPromoStore);
		mapPromoStore.setMstStore(null);

		return mapPromoStore;
	}

	public List<MstEmployee> getMstEmployees() {
		return this.mstEmployees;
	}

	public void setMstEmployees(List<MstEmployee> mstEmployees) {
		this.mstEmployees = mstEmployees;
	}

	public MstEmployee addMstEmployee(MstEmployee mstEmployee) {
		getMstEmployees().add(mstEmployee);
		mstEmployee.setMstStore(this);

		return mstEmployee;
	}

	public MstEmployee removeMstEmployee(MstEmployee mstEmployee) {
		getMstEmployees().remove(mstEmployee);
		mstEmployee.setMstStore(null);

		return mstEmployee;
	}

	public MstLocation getMstLocation() {
		return this.mstLocation;
	}

	public void setMstLocation(MstLocation mstLocation) {
		this.mstLocation = mstLocation;
	}

	public MstZone getMstZone() {
		return this.mstZone;
	}

	public void setMstZone(MstZone mstZone) {
		this.mstZone = mstZone;
	}

	public MstEmployee getMstEmployee() {
		return this.mstEmployee;
	}

	public void setMstEmployee(MstEmployee mstEmployee) {
		this.mstEmployee = mstEmployee;
	}

}