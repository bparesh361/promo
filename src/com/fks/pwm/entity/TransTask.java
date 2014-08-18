package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the trans_task database table.
 * 
 */
@Entity
@Table(name="trans_task")
@NamedQuery(name="TransTask.findAll", query="SELECT t FROM TransTask t")
public class TransTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="trans_task_id")
	private String transTaskId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="file_path")
	private String filePath;

	@Column(name="header_file_path")
	private String headerFilePath;

	@Column(name="is_ho")
	private byte isHo;

	@Column(name="promo_count")
	private int promoCount;

	private String remarks;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_time")
	private Date updatedTime;

	//bi-directional many-to-one association to MstStatus
	@ManyToOne
	@JoinColumn(name="current_status_id")
	private MstStatus mstStatus;

	//bi-directional many-to-one association to MstTask
	@ManyToOne
	@JoinColumn(name="mst_task_id")
	private MstTask mstTask;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="created_by")
	private MstEmployee mstEmployee1;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="updated_by")
	private MstEmployee mstEmployee2;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="assigned_to")
	private MstEmployee mstEmployee3;

	public TransTask() {
	}

	public String getTransTaskId() {
		return this.transTaskId;
	}

	public void setTransTaskId(String transTaskId) {
		this.transTaskId = transTaskId;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getHeaderFilePath() {
		return this.headerFilePath;
	}

	public void setHeaderFilePath(String headerFilePath) {
		this.headerFilePath = headerFilePath;
	}

	public byte getIsHo() {
		return this.isHo;
	}

	public void setIsHo(byte isHo) {
		this.isHo = isHo;
	}

	public int getPromoCount() {
		return this.promoCount;
	}

	public void setPromoCount(int promoCount) {
		this.promoCount = promoCount;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public MstStatus getMstStatus() {
		return this.mstStatus;
	}

	public void setMstStatus(MstStatus mstStatus) {
		this.mstStatus = mstStatus;
	}

	public MstTask getMstTask() {
		return this.mstTask;
	}

	public void setMstTask(MstTask mstTask) {
		this.mstTask = mstTask;
	}

	public MstEmployee getMstEmployee1() {
		return this.mstEmployee1;
	}

	public void setMstEmployee1(MstEmployee mstEmployee1) {
		this.mstEmployee1 = mstEmployee1;
	}

	public MstEmployee getMstEmployee2() {
		return this.mstEmployee2;
	}

	public void setMstEmployee2(MstEmployee mstEmployee2) {
		this.mstEmployee2 = mstEmployee2;
	}

	public MstEmployee getMstEmployee3() {
		return this.mstEmployee3;
	}

	public void setMstEmployee3(MstEmployee mstEmployee3) {
		this.mstEmployee3 = mstEmployee3;
	}

}