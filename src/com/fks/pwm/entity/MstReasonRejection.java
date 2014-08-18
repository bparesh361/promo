package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_reason_rejection database table.
 * 
 */
@Entity
@Table(name="mst_reason_rejection")
@NamedQuery(name="MstReasonRejection.findAll", query="SELECT m FROM MstReasonRejection m")
public class MstReasonRejection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="reason_rejection_id")
	private String reasonRejectionId;

	@Column(name="is_1")
	private byte is1;

	@Column(name="is_approver")
	private byte isApprover;

	@Column(name="is_blocked")
	private byte isBlocked;

	@Column(name="reason_name")
	private String reasonName;

	public MstReasonRejection() {
	}

	public String getReasonRejectionId() {
		return this.reasonRejectionId;
	}

	public void setReasonRejectionId(String reasonRejectionId) {
		this.reasonRejectionId = reasonRejectionId;
	}

	public byte getIs1() {
		return this.is1;
	}

	public void setIs1(byte is1) {
		this.is1 = is1;
	}

	public byte getIsApprover() {
		return this.isApprover;
	}

	public void setIsApprover(byte isApprover) {
		this.isApprover = isApprover;
	}

	public byte getIsBlocked() {
		return this.isBlocked;
	}

	public void setIsBlocked(byte isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getReasonName() {
		return this.reasonName;
	}

	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}

}