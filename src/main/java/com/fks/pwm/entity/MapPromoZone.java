package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the map_promo_zone database table.
 * 
 */
@Entity
@Table(name="map_promo_zone")
@NamedQuery(name="MapPromoZone.findAll", query="SELECT m FROM MapPromoZone m")
public class MapPromoZone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_promo_zone_id")
	private String mapPromoZoneId;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to MstZone
	@ManyToOne
	@JoinColumn(name="zone_id")
	private MstZone mstZone;

	//bi-directional many-to-one association to MstPromo
	@ManyToOne
	@JoinColumn(name="map_promo_id")
	private MstPromo mstPromo;

	public MapPromoZone() {
	}

	public String getMapPromoZoneId() {
		return this.mapPromoZoneId;
	}

	public void setMapPromoZoneId(String mapPromoZoneId) {
		this.mapPromoZoneId = mapPromoZoneId;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public MstZone getMstZone() {
		return this.mstZone;
	}

	public void setMstZone(MstZone mstZone) {
		this.mstZone = mstZone;
	}

	public MstPromo getMstPromo() {
		return this.mstPromo;
	}

	public void setMstPromo(MstPromo mstPromo) {
		this.mstPromo = mstPromo;
	}

}