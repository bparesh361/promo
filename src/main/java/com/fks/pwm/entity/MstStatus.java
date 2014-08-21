package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mst_status database table.
 * 
 */
@Entity
@Table(name="mst_status")
@NamedQuery(name="MstStatus.findAll", query="SELECT m FROM MstStatus m")
public class MstStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="status_id")
	private Long statusId;

	@Column(name="is_lead_time")
	private byte isLeadTime;

	private String l1;

	private String l2;

	private String l5;

	@Column(name="status_desc")
	private String statusDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to MstPromo
	@OneToMany(mappedBy="mstStatus")
	private List<MstPromo> mstPromos;

	//bi-directional many-to-one association to MstProposal
	@OneToMany(mappedBy="mstStatus")
	private List<MstProposal> mstProposals;

	//bi-directional many-to-one association to TransPromo
	@OneToMany(mappedBy="mstStatus")
	private List<TransPromo> transPromos;

	//bi-directional many-to-one association to TransPromoArticle
	@OneToMany(mappedBy="mstStatus")
	private List<TransPromoArticle> transPromoArticles;

	//bi-directional many-to-one association to TransPromoMc
	@OneToMany(mappedBy="mstStatus")
	private List<TransPromoMc> transPromoMcs;

	//bi-directional many-to-one association to TransPromoStatus
	@OneToMany(mappedBy="mstStatus1")
	private List<TransPromoStatus> transPromoStatuses1;

	//bi-directional many-to-one association to TransPromoStatus
	@OneToMany(mappedBy="mstStatus2")
	private List<TransPromoStatus> transPromoStatuses2;

	//bi-directional many-to-one association to TransTask
	@OneToMany(mappedBy="mstStatus")
	private List<TransTask> transTasks;

	public MstStatus() {
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public byte getIsLeadTime() {
		return this.isLeadTime;
	}

	public void setIsLeadTime(byte isLeadTime) {
		this.isLeadTime = isLeadTime;
	}

	public String getL1() {
		return this.l1;
	}

	public void setL1(String l1) {
		this.l1 = l1;
	}

	public String getL2() {
		return this.l2;
	}

	public void setL2(String l2) {
		this.l2 = l2;
	}

	public String getL5() {
		return this.l5;
	}

	public void setL5(String l5) {
		this.l5 = l5;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<MstPromo> getMstPromos() {
		return this.mstPromos;
	}

	public void setMstPromos(List<MstPromo> mstPromos) {
		this.mstPromos = mstPromos;
	}

	public MstPromo addMstPromo(MstPromo mstPromo) {
		getMstPromos().add(mstPromo);
		mstPromo.setMstStatus(this);

		return mstPromo;
	}

	public MstPromo removeMstPromo(MstPromo mstPromo) {
		getMstPromos().remove(mstPromo);
		mstPromo.setMstStatus(null);

		return mstPromo;
	}

	public List<MstProposal> getMstProposals() {
		return this.mstProposals;
	}

	public void setMstProposals(List<MstProposal> mstProposals) {
		this.mstProposals = mstProposals;
	}

	public MstProposal addMstProposal(MstProposal mstProposal) {
		getMstProposals().add(mstProposal);
		mstProposal.setMstStatus(this);

		return mstProposal;
	}

	public MstProposal removeMstProposal(MstProposal mstProposal) {
		getMstProposals().remove(mstProposal);
		mstProposal.setMstStatus(null);

		return mstProposal;
	}

	public List<TransPromo> getTransPromos() {
		return this.transPromos;
	}

	public void setTransPromos(List<TransPromo> transPromos) {
		this.transPromos = transPromos;
	}

	public TransPromo addTransPromo(TransPromo transPromo) {
		getTransPromos().add(transPromo);
		transPromo.setMstStatus(this);

		return transPromo;
	}

	public TransPromo removeTransPromo(TransPromo transPromo) {
		getTransPromos().remove(transPromo);
		transPromo.setMstStatus(null);

		return transPromo;
	}

	public List<TransPromoArticle> getTransPromoArticles() {
		return this.transPromoArticles;
	}

	public void setTransPromoArticles(List<TransPromoArticle> transPromoArticles) {
		this.transPromoArticles = transPromoArticles;
	}

	public TransPromoArticle addTransPromoArticle(TransPromoArticle transPromoArticle) {
		getTransPromoArticles().add(transPromoArticle);
		transPromoArticle.setMstStatus(this);

		return transPromoArticle;
	}

	public TransPromoArticle removeTransPromoArticle(TransPromoArticle transPromoArticle) {
		getTransPromoArticles().remove(transPromoArticle);
		transPromoArticle.setMstStatus(null);

		return transPromoArticle;
	}

	public List<TransPromoMc> getTransPromoMcs() {
		return this.transPromoMcs;
	}

	public void setTransPromoMcs(List<TransPromoMc> transPromoMcs) {
		this.transPromoMcs = transPromoMcs;
	}

	public TransPromoMc addTransPromoMc(TransPromoMc transPromoMc) {
		getTransPromoMcs().add(transPromoMc);
		transPromoMc.setMstStatus(this);

		return transPromoMc;
	}

	public TransPromoMc removeTransPromoMc(TransPromoMc transPromoMc) {
		getTransPromoMcs().remove(transPromoMc);
		transPromoMc.setMstStatus(null);

		return transPromoMc;
	}

	public List<TransPromoStatus> getTransPromoStatuses1() {
		return this.transPromoStatuses1;
	}

	public void setTransPromoStatuses1(List<TransPromoStatus> transPromoStatuses1) {
		this.transPromoStatuses1 = transPromoStatuses1;
	}

	public TransPromoStatus addTransPromoStatuses1(TransPromoStatus transPromoStatuses1) {
		getTransPromoStatuses1().add(transPromoStatuses1);
		transPromoStatuses1.setMstStatus1(this);

		return transPromoStatuses1;
	}

	public TransPromoStatus removeTransPromoStatuses1(TransPromoStatus transPromoStatuses1) {
		getTransPromoStatuses1().remove(transPromoStatuses1);
		transPromoStatuses1.setMstStatus1(null);

		return transPromoStatuses1;
	}

	public List<TransPromoStatus> getTransPromoStatuses2() {
		return this.transPromoStatuses2;
	}

	public void setTransPromoStatuses2(List<TransPromoStatus> transPromoStatuses2) {
		this.transPromoStatuses2 = transPromoStatuses2;
	}

	public TransPromoStatus addTransPromoStatuses2(TransPromoStatus transPromoStatuses2) {
		getTransPromoStatuses2().add(transPromoStatuses2);
		transPromoStatuses2.setMstStatus2(this);

		return transPromoStatuses2;
	}

	public TransPromoStatus removeTransPromoStatuses2(TransPromoStatus transPromoStatuses2) {
		getTransPromoStatuses2().remove(transPromoStatuses2);
		transPromoStatuses2.setMstStatus2(null);

		return transPromoStatuses2;
	}

	public List<TransTask> getTransTasks() {
		return this.transTasks;
	}

	public void setTransTasks(List<TransTask> transTasks) {
		this.transTasks = transTasks;
	}

	public TransTask addTransTask(TransTask transTask) {
		getTransTasks().add(transTask);
		transTask.setMstStatus(this);

		return transTask;
	}

	public TransTask removeTransTask(TransTask transTask) {
		getTransTasks().remove(transTask);
		transTask.setMstStatus(null);

		return transTask;
	}

}