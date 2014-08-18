package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the trans_promo_status database table.
 * 
 */
@Entity
@Table(name="trans_promo_status")
@NamedQuery(name="TransPromoStatus.findAll", query="SELECT t FROM TransPromoStatus t")
public class TransPromoStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="trans_promo_status_id")
	private String transPromoStatusId;

	private String remarks;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to TransPromo
	@ManyToOne
	@JoinColumn(name="trans_promo_id")
	private TransPromo transPromo;

	//bi-directional many-to-one association to MstStatus
	@ManyToOne
	@JoinColumn(name="previous_status_id")
	private MstStatus mstStatus1;

	//bi-directional many-to-one association to MstStatus
	@ManyToOne
	@JoinColumn(name="new_status_id")
	private MstStatus mstStatus2;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="updated_by")
	private MstEmployee mstEmployee;

	public TransPromoStatus() {
	}

	public String getTransPromoStatusId() {
		return this.transPromoStatusId;
	}

	public void setTransPromoStatusId(String transPromoStatusId) {
		this.transPromoStatusId = transPromoStatusId;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public TransPromo getTransPromo() {
		return this.transPromo;
	}

	public void setTransPromo(TransPromo transPromo) {
		this.transPromo = transPromo;
	}

	public MstStatus getMstStatus1() {
		return this.mstStatus1;
	}

	public void setMstStatus1(MstStatus mstStatus1) {
		this.mstStatus1 = mstStatus1;
	}

	public MstStatus getMstStatus2() {
		return this.mstStatus2;
	}

	public void setMstStatus2(MstStatus mstStatus2) {
		this.mstStatus2 = mstStatus2;
	}

	public MstEmployee getMstEmployee() {
		return this.mstEmployee;
	}

	public void setMstEmployee(MstEmployee mstEmployee) {
		this.mstEmployee = mstEmployee;
	}

}