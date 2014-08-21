package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_report_email database table.
 * 
 */
@Entity
@Table(name="mst_report_email")
@NamedQuery(name="MstReportEmail.findAll", query="SELECT m FROM MstReportEmail m")
public class MstReportEmail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mst_report_type_email_id")
	private String mstReportTypeEmailId;

	@Column(name="email_id")
	private String emailId;

	@Column(name="mst_zone_id")
	private String mstZoneId;

	@Column(name="mst_zone_name")
	private String mstZoneName;

	//bi-directional many-to-one association to MstReportType
	@ManyToOne
	@JoinColumn(name="mst_report_type_id")
	private MstReportType mstReportType;

	public MstReportEmail() {
	}

	public String getMstReportTypeEmailId() {
		return this.mstReportTypeEmailId;
	}

	public void setMstReportTypeEmailId(String mstReportTypeEmailId) {
		this.mstReportTypeEmailId = mstReportTypeEmailId;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMstZoneId() {
		return this.mstZoneId;
	}

	public void setMstZoneId(String mstZoneId) {
		this.mstZoneId = mstZoneId;
	}

	public String getMstZoneName() {
		return this.mstZoneName;
	}

	public void setMstZoneName(String mstZoneName) {
		this.mstZoneName = mstZoneName;
	}

	public MstReportType getMstReportType() {
		return this.mstReportType;
	}

	public void setMstReportType(MstReportType mstReportType) {
		this.mstReportType = mstReportType;
	}

}