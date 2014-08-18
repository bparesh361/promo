package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the trans_promo_mc database table.
 * 
 */
@Entity
@Table(name="trans_promo_mc")
@NamedQuery(name="TransPromoMc.findAll", query="SELECT t FROM TransPromoMc t")
public class TransPromoMc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="trans_promo_mc_id")
	private String transPromoMcId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to TransPromo
	@ManyToOne
	@JoinColumn(name="trans_promo_id")
	private TransPromo transPromo;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="updated_by")
	private MstEmployee mstEmployee;

	//bi-directional many-to-one association to MstStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private MstStatus mstStatus;

	//bi-directional many-to-one association to Mch
	@ManyToOne
	@JoinColumn(name="mc_code")
	private Mch mch;

	public TransPromoMc() {
	}

	public String getTransPromoMcId() {
		return this.transPromoMcId;
	}

	public void setTransPromoMcId(String transPromoMcId) {
		this.transPromoMcId = transPromoMcId;
	}

	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public TransPromo getTransPromo() {
		return this.transPromo;
	}

	public void setTransPromo(TransPromo transPromo) {
		this.transPromo = transPromo;
	}

	public MstEmployee getMstEmployee() {
		return this.mstEmployee;
	}

	public void setMstEmployee(MstEmployee mstEmployee) {
		this.mstEmployee = mstEmployee;
	}

	public MstStatus getMstStatus() {
		return this.mstStatus;
	}

	public void setMstStatus(MstStatus mstStatus) {
		this.mstStatus = mstStatus;
	}

	public Mch getMch() {
		return this.mch;
	}

	public void setMch(Mch mch) {
		this.mch = mch;
	}

}