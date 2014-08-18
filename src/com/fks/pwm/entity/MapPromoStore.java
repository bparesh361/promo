package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the map_promo_store database table.
 * 
 */
@Entity
@Table(name="map_promo_store")
@NamedQuery(name="MapPromoStore.findAll", query="SELECT m FROM MapPromoStore m")
public class MapPromoStore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_promo_store_id")
	private String mapPromoStoreId;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to MstPromo
	@ManyToOne
	@JoinColumn(name="promo_id")
	private MstPromo mstPromo;

	//bi-directional many-to-one association to MstStore
	@ManyToOne
	@JoinColumn(name="mst_store_id")
	private MstStore mstStore;

	public MapPromoStore() {
	}

	public String getMapPromoStoreId() {
		return this.mapPromoStoreId;
	}

	public void setMapPromoStoreId(String mapPromoStoreId) {
		this.mapPromoStoreId = mapPromoStoreId;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public MstPromo getMstPromo() {
		return this.mstPromo;
	}

	public void setMstPromo(MstPromo mstPromo) {
		this.mstPromo = mstPromo;
	}

	public MstStore getMstStore() {
		return this.mstStore;
	}

	public void setMstStore(MstStore mstStore) {
		this.mstStore = mstStore;
	}

}