package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the mst_article database table.
 * 
 */
@Entity
@Table(name="mst_article")
@NamedQuery(name="MstArticle.findAll", query="SELECT m FROM MstArticle m")
public class MstArticle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="article_code")
	private String articleCode;

	@Column(name="article_desc")
	private String articleDesc;

	private String brand;

	@Column(name="map_promo_bxgx_id")
	private BigInteger mapPromoBxgxId;

	@Column(name="mc_code")
	private String mcCode;

	@Column(name="season_code")
	private String seasonCode;

	public MstArticle() {
	}

	public String getArticleCode() {
		return this.articleCode;
	}

	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}

	public String getArticleDesc() {
		return this.articleDesc;
	}

	public void setArticleDesc(String articleDesc) {
		this.articleDesc = articleDesc;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigInteger getMapPromoBxgxId() {
		return this.mapPromoBxgxId;
	}

	public void setMapPromoBxgxId(BigInteger mapPromoBxgxId) {
		this.mapPromoBxgxId = mapPromoBxgxId;
	}

	public String getMcCode() {
		return this.mcCode;
	}

	public void setMcCode(String mcCode) {
		this.mcCode = mcCode;
	}

	public String getSeasonCode() {
		return this.seasonCode;
	}

	public void setSeasonCode(String seasonCode) {
		this.seasonCode = seasonCode;
	}

}