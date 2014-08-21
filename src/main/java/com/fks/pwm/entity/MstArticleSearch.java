package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mst_article_search database table.
 * 
 */
@Entity
@Table(name="mst_article_search")
@NamedQuery(name="MstArticleSearch.findAll", query="SELECT m FROM MstArticleSearch m")
public class MstArticleSearch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="article_search_id")
	private String articleSearchId;

	private String brand;

	@Column(name="download_file_path")
	private String downloadFilePath;

	@Column(name="mc_code")
	private String mcCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="search_date_time")
	private Date searchDateTime;

	@Column(name="season_code")
	private String seasonCode;

	private String status;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="created_by")
	private MstEmployee mstEmployee;

	public MstArticleSearch() {
	}

	public String getArticleSearchId() {
		return this.articleSearchId;
	}

	public void setArticleSearchId(String articleSearchId) {
		this.articleSearchId = articleSearchId;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDownloadFilePath() {
		return this.downloadFilePath;
	}

	public void setDownloadFilePath(String downloadFilePath) {
		this.downloadFilePath = downloadFilePath;
	}

	public String getMcCode() {
		return this.mcCode;
	}

	public void setMcCode(String mcCode) {
		this.mcCode = mcCode;
	}

	public Date getSearchDateTime() {
		return this.searchDateTime;
	}

	public void setSearchDateTime(Date searchDateTime) {
		this.searchDateTime = searchDateTime;
	}

	public String getSeasonCode() {
		return this.seasonCode;
	}

	public void setSeasonCode(String seasonCode) {
		this.seasonCode = seasonCode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MstEmployee getMstEmployee() {
		return this.mstEmployee;
	}

	public void setMstEmployee(MstEmployee mstEmployee) {
		this.mstEmployee = mstEmployee;
	}

}