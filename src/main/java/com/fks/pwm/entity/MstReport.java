package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the mst_report database table.
 * 
 */
@Entity
@Table(name="mst_report")
@NamedQuery(name="MstReport.findAll", query="SELECT m FROM MstReport m")
public class MstReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="report_id")
	private String reportId;

	private String category;

	@Column(name="created_by")
	private BigInteger createdBy;

	@Column(name="event_id")
	private BigInteger eventId;

	@Column(name="file_path")
	private String filePath;

	@Column(name="initiated_from")
	private String initiatedFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="initiation_date_from")
	private Date initiationDateFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="initiation_date_to")
	private Date initiationDateTo;

	@Column(name="proposal_id")
	private String proposalId;

	@Column(name="proposal_problem_type_id")
	private BigInteger proposalProblemTypeId;

	private String remarks;

	@Temporal(TemporalType.DATE)
	@Column(name="report_date")
	private Date reportDate;

	@Column(name="report_status_id")
	private BigInteger reportStatusId;

	@Column(name="search_status_id")
	private BigInteger searchStatusId;

	@Column(name="search_status_name")
	private String searchStatusName;

	@Column(name="sub_category")
	private String subCategory;

	@Column(name="task_type_id")
	private BigInteger taskTypeId;

	@Column(name="ticket_number")
	private String ticketNumber;

	@Column(name="vendor_backed")
	private String vendorBacked;

	@Column(name="zone_id")
	private BigInteger zoneId;

	//bi-directional many-to-one association to MstReportType
	@ManyToOne
	@JoinColumn(name="mst_report_type_id")
	private MstReportType mstReportType;

	public MstReport() {
	}

	public String getReportId() {
		return this.reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigInteger getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}

	public BigInteger getEventId() {
		return this.eventId;
	}

	public void setEventId(BigInteger eventId) {
		this.eventId = eventId;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getInitiatedFrom() {
		return this.initiatedFrom;
	}

	public void setInitiatedFrom(String initiatedFrom) {
		this.initiatedFrom = initiatedFrom;
	}

	public Date getInitiationDateFrom() {
		return this.initiationDateFrom;
	}

	public void setInitiationDateFrom(Date initiationDateFrom) {
		this.initiationDateFrom = initiationDateFrom;
	}

	public Date getInitiationDateTo() {
		return this.initiationDateTo;
	}

	public void setInitiationDateTo(Date initiationDateTo) {
		this.initiationDateTo = initiationDateTo;
	}

	public String getProposalId() {
		return this.proposalId;
	}

	public void setProposalId(String proposalId) {
		this.proposalId = proposalId;
	}

	public BigInteger getProposalProblemTypeId() {
		return this.proposalProblemTypeId;
	}

	public void setProposalProblemTypeId(BigInteger proposalProblemTypeId) {
		this.proposalProblemTypeId = proposalProblemTypeId;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public BigInteger getReportStatusId() {
		return this.reportStatusId;
	}

	public void setReportStatusId(BigInteger reportStatusId) {
		this.reportStatusId = reportStatusId;
	}

	public BigInteger getSearchStatusId() {
		return this.searchStatusId;
	}

	public void setSearchStatusId(BigInteger searchStatusId) {
		this.searchStatusId = searchStatusId;
	}

	public String getSearchStatusName() {
		return this.searchStatusName;
	}

	public void setSearchStatusName(String searchStatusName) {
		this.searchStatusName = searchStatusName;
	}

	public String getSubCategory() {
		return this.subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public BigInteger getTaskTypeId() {
		return this.taskTypeId;
	}

	public void setTaskTypeId(BigInteger taskTypeId) {
		this.taskTypeId = taskTypeId;
	}

	public String getTicketNumber() {
		return this.ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getVendorBacked() {
		return this.vendorBacked;
	}

	public void setVendorBacked(String vendorBacked) {
		this.vendorBacked = vendorBacked;
	}

	public BigInteger getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(BigInteger zoneId) {
		this.zoneId = zoneId;
	}

	public MstReportType getMstReportType() {
		return this.mstReportType;
	}

	public void setMstReportType(MstReportType mstReportType) {
		this.mstReportType = mstReportType;
	}

}