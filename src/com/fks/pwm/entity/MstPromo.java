package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mst_promo database table.
 * 
 */
@Entity
@Table(name="mst_promo")
@NamedQuery(name="MstPromo.findAll", query="SELECT m FROM MstPromo m")
public class MstPromo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="promo_id")
	private String promoId;

	private String category;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="error_file_path")
	private String errorFilePath;

	@Column(name="file_path")
	private String filePath;

	private String remarks;

	@Column(name="request_name")
	private String requestName;

	@Column(name="sub_category")
	private String subCategory;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	@Column(name="vendor_backed")
	private String vendorBacked;

	//bi-directional many-to-one association to MapPromoCity
	@OneToMany(mappedBy="mstPromo")
	private List<MapPromoCity> mapPromoCities;

	//bi-directional many-to-one association to MapPromoFormat
	@OneToMany(mappedBy="mstPromo")
	private List<MapPromoFormat> mapPromoFormats;

	//bi-directional many-to-one association to MapPromoMch
	@OneToMany(mappedBy="mstPromo")
	private List<MapPromoMch> mapPromoMches;

	//bi-directional many-to-one association to MapPromoRegion
	@OneToMany(mappedBy="mstPromo")
	private List<MapPromoRegion> mapPromoRegions;

	//bi-directional many-to-one association to MapPromoState
	@OneToMany(mappedBy="mstPromo")
	private List<MapPromoState> mapPromoStates;

	//bi-directional many-to-one association to MapPromoStore
	@OneToMany(mappedBy="mstPromo")
	private List<MapPromoStore> mapPromoStores;

	//bi-directional many-to-one association to MapPromoZone
	@OneToMany(mappedBy="mstPromo")
	private List<MapPromoZone> mapPromoZones;

	//bi-directional many-to-one association to MstEvent
	@ManyToOne
	@JoinColumn(name="event_id")
	private MstEvent mstEvent;

	//bi-directional many-to-one association to MstMktg
	@ManyToOne
	@JoinColumn(name="mktg_id")
	private MstMktg mstMktg;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="created_by")
	private MstEmployee mstEmployee1;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="updated_by")
	private MstEmployee mstEmployee2;

	//bi-directional many-to-one association to MstStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private MstStatus mstStatus;

	//bi-directional many-to-one association to MstCampaign
	@ManyToOne
	@JoinColumn(name="campaign_id")
	private MstCampaign mstCampaign;

	//bi-directional many-to-one association to TransPromo
	@OneToMany(mappedBy="mstPromo")
	private List<TransPromo> transPromos;

	public MstPromo() {
	}

	public String getPromoId() {
		return this.promoId;
	}

	public void setPromoId(String promoId) {
		this.promoId = promoId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getErrorFilePath() {
		return this.errorFilePath;
	}

	public void setErrorFilePath(String errorFilePath) {
		this.errorFilePath = errorFilePath;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRequestName() {
		return this.requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public String getSubCategory() {
		return this.subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getVendorBacked() {
		return this.vendorBacked;
	}

	public void setVendorBacked(String vendorBacked) {
		this.vendorBacked = vendorBacked;
	}

	public List<MapPromoCity> getMapPromoCities() {
		return this.mapPromoCities;
	}

	public void setMapPromoCities(List<MapPromoCity> mapPromoCities) {
		this.mapPromoCities = mapPromoCities;
	}

	public MapPromoCity addMapPromoCity(MapPromoCity mapPromoCity) {
		getMapPromoCities().add(mapPromoCity);
		mapPromoCity.setMstPromo(this);

		return mapPromoCity;
	}

	public MapPromoCity removeMapPromoCity(MapPromoCity mapPromoCity) {
		getMapPromoCities().remove(mapPromoCity);
		mapPromoCity.setMstPromo(null);

		return mapPromoCity;
	}

	public List<MapPromoFormat> getMapPromoFormats() {
		return this.mapPromoFormats;
	}

	public void setMapPromoFormats(List<MapPromoFormat> mapPromoFormats) {
		this.mapPromoFormats = mapPromoFormats;
	}

	public MapPromoFormat addMapPromoFormat(MapPromoFormat mapPromoFormat) {
		getMapPromoFormats().add(mapPromoFormat);
		mapPromoFormat.setMstPromo(this);

		return mapPromoFormat;
	}

	public MapPromoFormat removeMapPromoFormat(MapPromoFormat mapPromoFormat) {
		getMapPromoFormats().remove(mapPromoFormat);
		mapPromoFormat.setMstPromo(null);

		return mapPromoFormat;
	}

	public List<MapPromoMch> getMapPromoMches() {
		return this.mapPromoMches;
	}

	public void setMapPromoMches(List<MapPromoMch> mapPromoMches) {
		this.mapPromoMches = mapPromoMches;
	}

	public MapPromoMch addMapPromoMch(MapPromoMch mapPromoMch) {
		getMapPromoMches().add(mapPromoMch);
		mapPromoMch.setMstPromo(this);

		return mapPromoMch;
	}

	public MapPromoMch removeMapPromoMch(MapPromoMch mapPromoMch) {
		getMapPromoMches().remove(mapPromoMch);
		mapPromoMch.setMstPromo(null);

		return mapPromoMch;
	}

	public List<MapPromoRegion> getMapPromoRegions() {
		return this.mapPromoRegions;
	}

	public void setMapPromoRegions(List<MapPromoRegion> mapPromoRegions) {
		this.mapPromoRegions = mapPromoRegions;
	}

	public MapPromoRegion addMapPromoRegion(MapPromoRegion mapPromoRegion) {
		getMapPromoRegions().add(mapPromoRegion);
		mapPromoRegion.setMstPromo(this);

		return mapPromoRegion;
	}

	public MapPromoRegion removeMapPromoRegion(MapPromoRegion mapPromoRegion) {
		getMapPromoRegions().remove(mapPromoRegion);
		mapPromoRegion.setMstPromo(null);

		return mapPromoRegion;
	}

	public List<MapPromoState> getMapPromoStates() {
		return this.mapPromoStates;
	}

	public void setMapPromoStates(List<MapPromoState> mapPromoStates) {
		this.mapPromoStates = mapPromoStates;
	}

	public MapPromoState addMapPromoState(MapPromoState mapPromoState) {
		getMapPromoStates().add(mapPromoState);
		mapPromoState.setMstPromo(this);

		return mapPromoState;
	}

	public MapPromoState removeMapPromoState(MapPromoState mapPromoState) {
		getMapPromoStates().remove(mapPromoState);
		mapPromoState.setMstPromo(null);

		return mapPromoState;
	}

	public List<MapPromoStore> getMapPromoStores() {
		return this.mapPromoStores;
	}

	public void setMapPromoStores(List<MapPromoStore> mapPromoStores) {
		this.mapPromoStores = mapPromoStores;
	}

	public MapPromoStore addMapPromoStore(MapPromoStore mapPromoStore) {
		getMapPromoStores().add(mapPromoStore);
		mapPromoStore.setMstPromo(this);

		return mapPromoStore;
	}

	public MapPromoStore removeMapPromoStore(MapPromoStore mapPromoStore) {
		getMapPromoStores().remove(mapPromoStore);
		mapPromoStore.setMstPromo(null);

		return mapPromoStore;
	}

	public List<MapPromoZone> getMapPromoZones() {
		return this.mapPromoZones;
	}

	public void setMapPromoZones(List<MapPromoZone> mapPromoZones) {
		this.mapPromoZones = mapPromoZones;
	}

	public MapPromoZone addMapPromoZone(MapPromoZone mapPromoZone) {
		getMapPromoZones().add(mapPromoZone);
		mapPromoZone.setMstPromo(this);

		return mapPromoZone;
	}

	public MapPromoZone removeMapPromoZone(MapPromoZone mapPromoZone) {
		getMapPromoZones().remove(mapPromoZone);
		mapPromoZone.setMstPromo(null);

		return mapPromoZone;
	}

	public MstEvent getMstEvent() {
		return this.mstEvent;
	}

	public void setMstEvent(MstEvent mstEvent) {
		this.mstEvent = mstEvent;
	}

	public MstMktg getMstMktg() {
		return this.mstMktg;
	}

	public void setMstMktg(MstMktg mstMktg) {
		this.mstMktg = mstMktg;
	}

	public MstEmployee getMstEmployee1() {
		return this.mstEmployee1;
	}

	public void setMstEmployee1(MstEmployee mstEmployee1) {
		this.mstEmployee1 = mstEmployee1;
	}

	public MstEmployee getMstEmployee2() {
		return this.mstEmployee2;
	}

	public void setMstEmployee2(MstEmployee mstEmployee2) {
		this.mstEmployee2 = mstEmployee2;
	}

	public MstStatus getMstStatus() {
		return this.mstStatus;
	}

	public void setMstStatus(MstStatus mstStatus) {
		this.mstStatus = mstStatus;
	}

	public MstCampaign getMstCampaign() {
		return this.mstCampaign;
	}

	public void setMstCampaign(MstCampaign mstCampaign) {
		this.mstCampaign = mstCampaign;
	}

	public List<TransPromo> getTransPromos() {
		return this.transPromos;
	}

	public void setTransPromos(List<TransPromo> transPromos) {
		this.transPromos = transPromos;
	}

	public TransPromo addTransPromo(TransPromo transPromo) {
		getTransPromos().add(transPromo);
		transPromo.setMstPromo(this);

		return transPromo;
	}

	public TransPromo removeTransPromo(TransPromo transPromo) {
		getTransPromos().remove(transPromo);
		transPromo.setMstPromo(null);

		return transPromo;
	}

}