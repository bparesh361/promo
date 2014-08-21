package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the trans_promo_article database table.
 * 
 */
@Entity
@Table(name="trans_promo_article")
@NamedQuery(name="TransPromoArticle.findAll", query="SELECT t FROM TransPromoArticle t")
public class TransPromoArticle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="trans_promo_article_id")
	private String transPromoArticleId;

	private String article;

	@Column(name="article_desc")
	private String articleDesc;

	@Column(name="brand_code")
	private String brandCode;

	@Column(name="brand_desc")
	private String brandDesc;

	@Column(name="buy_qty")
	private int buyQty;

	@Column(name="get_qty")
	private int getQty;

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

	@Column(name="mc_code")
	private String mcCode;

	@Column(name="mc_desc")
	private String mcDesc;

	private String mrp;

	private int qty;

	@Column(name="set_id")
	private int setId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to TransPromo
	@ManyToOne
	@JoinColumn(name="trans_promo_id")
	private TransPromo transPromo;

	//bi-directional many-to-one association to MstStatus
	@ManyToOne
	@JoinColumn(name="current_status_id")
	private MstStatus mstStatus;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="updated_by")
	private MstEmployee mstEmployee;

	public TransPromoArticle() {
	}

	public String getTransPromoArticleId() {
		return this.transPromoArticleId;
	}

	public void setTransPromoArticleId(String transPromoArticleId) {
		this.transPromoArticleId = transPromoArticleId;
	}

	public String getArticle() {
		return this.article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getArticleDesc() {
		return this.articleDesc;
	}

	public void setArticleDesc(String articleDesc) {
		this.articleDesc = articleDesc;
	}

	public String getBrandCode() {
		return this.brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getBrandDesc() {
		return this.brandDesc;
	}

	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}

	public int getBuyQty() {
		return this.buyQty;
	}

	public void setBuyQty(int buyQty) {
		this.buyQty = buyQty;
	}

	public int getGetQty() {
		return this.getQty;
	}

	public void setGetQty(int getQty) {
		this.getQty = getQty;
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

	public String getMcCode() {
		return this.mcCode;
	}

	public void setMcCode(String mcCode) {
		this.mcCode = mcCode;
	}

	public String getMcDesc() {
		return this.mcDesc;
	}

	public void setMcDesc(String mcDesc) {
		this.mcDesc = mcDesc;
	}

	public String getMrp() {
		return this.mrp;
	}

	public void setMrp(String mrp) {
		this.mrp = mrp;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getSetId() {
		return this.setId;
	}

	public void setSetId(int setId) {
		this.setId = setId;
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

	public MstStatus getMstStatus() {
		return this.mstStatus;
	}

	public void setMstStatus(MstStatus mstStatus) {
		this.mstStatus = mstStatus;
	}

	public MstEmployee getMstEmployee() {
		return this.mstEmployee;
	}

	public void setMstEmployee(MstEmployee mstEmployee) {
		this.mstEmployee = mstEmployee;
	}

}