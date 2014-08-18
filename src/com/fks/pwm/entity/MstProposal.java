package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mst_proposal database table.
 * 
 */
@Entity
@Table(name="mst_proposal")
@NamedQuery(name="MstProposal.findAll", query="SELECT m FROM MstProposal m")
public class MstProposal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="proposal_id")
	private String proposalId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="file_path")
	private String filePath;

	@Column(name="file_status")
	private byte fileStatus;

	@Column(name="initiator_remarks")
	private String initiatorRemarks;

	@Column(name="other_file_path")
	private String otherFilePath;

	@Column(name="promo_desc")
	private String promoDesc;

	private String remarks;

	@Column(name="solution_desc")
	private String solutionDesc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	@Column(name="zone_id")
	private String zoneId;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private MstEmployee mstEmployee;

	//bi-directional many-to-one association to MstProblem
	@ManyToOne
	@JoinColumn(name="problem_type_id")
	private MstProblem mstProblem;

	//bi-directional many-to-one association to MstPromotionType
	@ManyToOne
	@JoinColumn(name="promo_type_id")
	private MstPromotionType mstPromotionType;

	//bi-directional many-to-one association to MstDepartment
	@ManyToOne
	@JoinColumn(name="dept_id")
	private MstDepartment mstDepartment;

	//bi-directional many-to-one association to MstStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private MstStatus mstStatus;

	//bi-directional many-to-one association to TransProposal
	@OneToMany(mappedBy="mstProposal")
	private List<TransProposal> transProposals;

	public MstProposal() {
	}

	public String getProposalId() {
		return this.proposalId;
	}

	public void setProposalId(String proposalId) {
		this.proposalId = proposalId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public byte getFileStatus() {
		return this.fileStatus;
	}

	public void setFileStatus(byte fileStatus) {
		this.fileStatus = fileStatus;
	}

	public String getInitiatorRemarks() {
		return this.initiatorRemarks;
	}

	public void setInitiatorRemarks(String initiatorRemarks) {
		this.initiatorRemarks = initiatorRemarks;
	}

	public String getOtherFilePath() {
		return this.otherFilePath;
	}

	public void setOtherFilePath(String otherFilePath) {
		this.otherFilePath = otherFilePath;
	}

	public String getPromoDesc() {
		return this.promoDesc;
	}

	public void setPromoDesc(String promoDesc) {
		this.promoDesc = promoDesc;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSolutionDesc() {
		return this.solutionDesc;
	}

	public void setSolutionDesc(String solutionDesc) {
		this.solutionDesc = solutionDesc;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public MstEmployee getMstEmployee() {
		return this.mstEmployee;
	}

	public void setMstEmployee(MstEmployee mstEmployee) {
		this.mstEmployee = mstEmployee;
	}

	public MstProblem getMstProblem() {
		return this.mstProblem;
	}

	public void setMstProblem(MstProblem mstProblem) {
		this.mstProblem = mstProblem;
	}

	public MstPromotionType getMstPromotionType() {
		return this.mstPromotionType;
	}

	public void setMstPromotionType(MstPromotionType mstPromotionType) {
		this.mstPromotionType = mstPromotionType;
	}

	public MstDepartment getMstDepartment() {
		return this.mstDepartment;
	}

	public void setMstDepartment(MstDepartment mstDepartment) {
		this.mstDepartment = mstDepartment;
	}

	public MstStatus getMstStatus() {
		return this.mstStatus;
	}

	public void setMstStatus(MstStatus mstStatus) {
		this.mstStatus = mstStatus;
	}

	public List<TransProposal> getTransProposals() {
		return this.transProposals;
	}

	public void setTransProposals(List<TransProposal> transProposals) {
		this.transProposals = transProposals;
	}

	public TransProposal addTransProposal(TransProposal transProposal) {
		getTransProposals().add(transProposal);
		transProposal.setMstProposal(this);

		return transProposal;
	}

	public TransProposal removeTransProposal(TransProposal transProposal) {
		getTransProposals().remove(transProposal);
		transProposal.setMstProposal(null);

		return transProposal;
	}

}