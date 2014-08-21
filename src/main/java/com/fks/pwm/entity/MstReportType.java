package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_report_type database table.
 * 
 */
@Entity
@Table(name="mst_report_type")
@NamedQuery(name="MstReportType.findAll", query="SELECT m FROM MstReportType m")
public class MstReportType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mst_report_type_id")
	private String mstReportTypeId;

	@Column(name="mst_report_type_desc")
	private String mstReportTypeDesc;

	//bi-directional many-to-one association to MstReport
	@OneToMany(mappedBy="mstReportType")
	private List<MstReport> mstReports;

	//bi-directional many-to-one association to MstReportEmail
	@OneToMany(mappedBy="mstReportType")
	private List<MstReportEmail> mstReportEmails;

	public MstReportType() {
	}

	public String getMstReportTypeId() {
		return this.mstReportTypeId;
	}

	public void setMstReportTypeId(String mstReportTypeId) {
		this.mstReportTypeId = mstReportTypeId;
	}

	public String getMstReportTypeDesc() {
		return this.mstReportTypeDesc;
	}

	public void setMstReportTypeDesc(String mstReportTypeDesc) {
		this.mstReportTypeDesc = mstReportTypeDesc;
	}

	public List<MstReport> getMstReports() {
		return this.mstReports;
	}

	public void setMstReports(List<MstReport> mstReports) {
		this.mstReports = mstReports;
	}

	public MstReport addMstReport(MstReport mstReport) {
		getMstReports().add(mstReport);
		mstReport.setMstReportType(this);

		return mstReport;
	}

	public MstReport removeMstReport(MstReport mstReport) {
		getMstReports().remove(mstReport);
		mstReport.setMstReportType(null);

		return mstReport;
	}

	public List<MstReportEmail> getMstReportEmails() {
		return this.mstReportEmails;
	}

	public void setMstReportEmails(List<MstReportEmail> mstReportEmails) {
		this.mstReportEmails = mstReportEmails;
	}

	public MstReportEmail addMstReportEmail(MstReportEmail mstReportEmail) {
		getMstReportEmails().add(mstReportEmail);
		mstReportEmail.setMstReportType(this);

		return mstReportEmail;
	}

	public MstReportEmail removeMstReportEmail(MstReportEmail mstReportEmail) {
		getMstReportEmails().remove(mstReportEmail);
		mstReportEmail.setMstReportType(null);

		return mstReportEmail;
	}

}