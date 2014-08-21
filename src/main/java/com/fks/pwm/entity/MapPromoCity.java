package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the map_promo_city database table.
 * 
 */
@Entity
@Table(name="map_promo_city")
@NamedQuery(name="MapPromoCity.findAll", query="SELECT m FROM MapPromoCity m")
public class MapPromoCity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_promo_city_id")
	private String mapPromoCityId;

	@Column(name="city_desc")
	private String cityDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to MstPromo
	@ManyToOne
	@JoinColumn(name="promo_id")
	private MstPromo mstPromo;

	public MapPromoCity() {
	}

	public String getMapPromoCityId() {
		return this.mapPromoCityId;
	}

	public void setMapPromoCityId(String mapPromoCityId) {
		this.mapPromoCityId = mapPromoCityId;
	}

	public String getCityDesc() {
		return this.cityDesc;
	}

	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
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