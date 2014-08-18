package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trans_promo_file database table.
 * 
 */
@Entity
@Table(name="trans_promo_file")
@NamedQuery(name="TransPromoFile.findAll", query="SELECT t FROM TransPromoFile t")
public class TransPromoFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="map_trans_promo_file_id")
	private String mapTransPromoFileId;

	@Column(name="error_file_path")
	private String errorFilePath;

	@Column(name="file_path")
	private String filePath;

	@Column(name="is_article_file")
	private byte isArticleFile;

	private String remarks;

	@Column(name="set_id")
	private int setId;

	//bi-directional many-to-one association to TransPromo
	@ManyToOne
	@JoinColumn(name="trans_promo_id")
	private TransPromo transPromo;

	public TransPromoFile() {
	}

	public String getMapTransPromoFileId() {
		return this.mapTransPromoFileId;
	}

	public void setMapTransPromoFileId(String mapTransPromoFileId) {
		this.mapTransPromoFileId = mapTransPromoFileId;
	}

	public String getErrorFilePath() {
		return this.errorFilePath;
	}

	public void setErrorFilePath(String errorFilePath) {
		this.errorFilePath = errorFilePath;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public byte getIsArticleFile() {
		return this.isArticleFile;
	}

	public void setIsArticleFile(byte isArticleFile) {
		this.isArticleFile = isArticleFile;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getSetId() {
		return this.setId;
	}

	public void setSetId(int setId) {
		this.setId = setId;
	}

	public TransPromo getTransPromo() {
		return this.transPromo;
	}

	public void setTransPromo(TransPromo transPromo) {
		this.transPromo = transPromo;
	}

}