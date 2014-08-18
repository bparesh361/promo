package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the map_promo_format database table.
 * 
 */
@Entity
@Table(name="map_promo_format")
@NamedQuery(name="MapPromoFormat.findAll", query="SELECT m FROM MapPromoFormat m")
public class MapPromoFormat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_promo_format_id")
	private String mapPromoFormatId;

	@Column(name="format_desc")
	private String formatDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to MstPromo
	@ManyToOne
	@JoinColumn(name="promo_id")
	private MstPromo mstPromo;

	public MapPromoFormat() {
	}

	public String getMapPromoFormatId() {
		return this.mapPromoFormatId;
	}

	public void setMapPromoFormatId(String mapPromoFormatId) {
		this.mapPromoFormatId = mapPromoFormatId;
	}

	public String getFormatDesc() {
		return this.formatDesc;
	}

	public void setFormatDesc(String formatDesc) {
		this.formatDesc = formatDesc;
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