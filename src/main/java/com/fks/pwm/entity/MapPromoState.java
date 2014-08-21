package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the map_promo_state database table.
 * 
 */
@Entity
@Table(name="map_promo_state")
@NamedQuery(name="MapPromoState.findAll", query="SELECT m FROM MapPromoState m")
public class MapPromoState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_promo_state_id")
	private String mapPromoStateId;

	@Column(name="state_desc")
	private String stateDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to MstPromo
	@ManyToOne
	@JoinColumn(name="promo_id")
	private MstPromo mstPromo;

	public MapPromoState() {
	}

	public String getMapPromoStateId() {
		return this.mapPromoStateId;
	}

	public void setMapPromoStateId(String mapPromoStateId) {
		this.mapPromoStateId = mapPromoStateId;
	}

	public String getStateDesc() {
		return this.stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
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