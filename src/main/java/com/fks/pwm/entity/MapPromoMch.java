package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the map_promo_mch database table.
 * 
 */
@Entity
@Table(name="map_promo_mch")
@NamedQuery(name="MapPromoMch.findAll", query="SELECT m FROM MapPromoMch m")
public class MapPromoMch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_promo_mch_id")
	private String mapPromoMchId;

	//bi-directional many-to-one association to Mch
	@ManyToOne
	@JoinColumn(name="mch_code")
	private Mch mch;

	//bi-directional many-to-one association to MstPromo
	@ManyToOne
	@JoinColumn(name="mst_promo_id")
	private MstPromo mstPromo;

	public MapPromoMch() {
	}

	public String getMapPromoMchId() {
		return this.mapPromoMchId;
	}

	public void setMapPromoMchId(String mapPromoMchId) {
		this.mapPromoMchId = mapPromoMchId;
	}

	public Mch getMch() {
		return this.mch;
	}

	public void setMch(Mch mch) {
		this.mch = mch;
	}

	public MstPromo getMstPromo() {
		return this.mstPromo;
	}

	public void setMstPromo(MstPromo mstPromo) {
		this.mstPromo = mstPromo;
	}

}