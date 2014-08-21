package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the trans_promo_config database table.
 * 
 */
@Entity
@Table(name="trans_promo_config")
@NamedQuery(name="TransPromoConfig.findAll", query="SELECT t FROM TransPromoConfig t")
public class TransPromoConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="trans_promo_config_id")
	private String transPromoConfigId;

	@Column(name="discount_config")
	private String discountConfig;

	@Column(name="discount_value")
	private double discountValue;

	@Column(name="growth_conversion")
	private double growthConversion;

	@Column(name="is_a")
	private byte isA;

	@Column(name="is_b")
	private byte isB;

	@Column(name="is_x")
	private byte isX;

	@Column(name="is_y")
	private byte isY;

	@Column(name="is_z")
	private byte isZ;

	@Column(name="margin_achivement")
	private double marginAchivement;

	private int qty;

	@Column(name="sales_growth")
	private double salesGrowth;

	private double sell_thru_vs_Qty;

	@Column(name="set_id")
	private int setId;

	@Column(name="ticket_disc_amt")
	private double ticketDiscAmt;

	@Column(name="ticket_size_growth")
	private double ticketSizeGrowth;

	@Column(name="ticket_worth_amt")
	private double ticketWorthAmt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="valid_from")
	private Date validFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="valid_to")
	private Date validTo;

	//bi-directional many-to-one association to TransPromo
	@ManyToOne
	@JoinColumn(name="tras_promo_id")
	private TransPromo transPromo;

	public TransPromoConfig() {
	}

	public String getTransPromoConfigId() {
		return this.transPromoConfigId;
	}

	public void setTransPromoConfigId(String transPromoConfigId) {
		this.transPromoConfigId = transPromoConfigId;
	}

	public String getDiscountConfig() {
		return this.discountConfig;
	}

	public void setDiscountConfig(String discountConfig) {
		this.discountConfig = discountConfig;
	}

	public double getDiscountValue() {
		return this.discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}

	public double getGrowthConversion() {
		return this.growthConversion;
	}

	public void setGrowthConversion(double growthConversion) {
		this.growthConversion = growthConversion;
	}

	public byte getIsA() {
		return this.isA;
	}

	public void setIsA(byte isA) {
		this.isA = isA;
	}

	public byte getIsB() {
		return this.isB;
	}

	public void setIsB(byte isB) {
		this.isB = isB;
	}

	public byte getIsX() {
		return this.isX;
	}

	public void setIsX(byte isX) {
		this.isX = isX;
	}

	public byte getIsY() {
		return this.isY;
	}

	public void setIsY(byte isY) {
		this.isY = isY;
	}

	public byte getIsZ() {
		return this.isZ;
	}

	public void setIsZ(byte isZ) {
		this.isZ = isZ;
	}

	public double getMarginAchivement() {
		return this.marginAchivement;
	}

	public void setMarginAchivement(double marginAchivement) {
		this.marginAchivement = marginAchivement;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getSalesGrowth() {
		return this.salesGrowth;
	}

	public void setSalesGrowth(double salesGrowth) {
		this.salesGrowth = salesGrowth;
	}

	public double getSell_thru_vs_Qty() {
		return this.sell_thru_vs_Qty;
	}

	public void setSell_thru_vs_Qty(double sell_thru_vs_Qty) {
		this.sell_thru_vs_Qty = sell_thru_vs_Qty;
	}

	public int getSetId() {
		return this.setId;
	}

	public void setSetId(int setId) {
		this.setId = setId;
	}

	public double getTicketDiscAmt() {
		return this.ticketDiscAmt;
	}

	public void setTicketDiscAmt(double ticketDiscAmt) {
		this.ticketDiscAmt = ticketDiscAmt;
	}

	public double getTicketSizeGrowth() {
		return this.ticketSizeGrowth;
	}

	public void setTicketSizeGrowth(double ticketSizeGrowth) {
		this.ticketSizeGrowth = ticketSizeGrowth;
	}

	public double getTicketWorthAmt() {
		return this.ticketWorthAmt;
	}

	public void setTicketWorthAmt(double ticketWorthAmt) {
		this.ticketWorthAmt = ticketWorthAmt;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public TransPromo getTransPromo() {
		return this.transPromo;
	}

	public void setTransPromo(TransPromo transPromo) {
		this.transPromo = transPromo;
	}

}