package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the map_promo_region database table.
 * 
 */
@Entity
@Table(name="map_promo_region")
@NamedQuery(name="MapPromoRegion.findAll", query="SELECT m FROM MapPromoRegion m")
public class MapPromoRegion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_promo_region_id")
	private String mapPromoRegionId;

	@Column(name="region_name")
	private String regionName;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to MstPromo
	@ManyToOne
	@JoinColumn(name="promo_id")
	private MstPromo mstPromo;

	public MapPromoRegion() {
	}

	public String getMapPromoRegionId() {
		return this.mapPromoRegionId;
	}

	public void setMapPromoRegionId(String mapPromoRegionId) {
		this.mapPromoRegionId = mapPromoRegionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
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

}