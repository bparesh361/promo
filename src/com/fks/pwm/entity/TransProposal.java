package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trans_proposal database table.
 * 
 */
@Entity
@Table(name="trans_proposal")
@NamedQuery(name="TransProposal.findAll", query="SELECT t FROM TransProposal t")
public class TransProposal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="trans_proposal_id")
	private String transProposalId;

	@Column(name="art_code")
	private String artCode;

	@Column(name="art_desc")
	private String artDesc;

	@Column(name="mc_code")
	private String mcCode;

	@Column(name="mc_desc")
	private String mcDesc;

	//bi-directional many-to-one association to MstProposal
	@ManyToOne
	@JoinColumn(name="proposal_id")
	private MstProposal mstProposal;

	public TransProposal() {
	}

	public String getTransProposalId() {
		return this.transProposalId;
	}

	public void setTransProposalId(String transProposalId) {
		this.transProposalId = transProposalId;
	}

	public String getArtCode() {
		return this.artCode;
	}

	public void setArtCode(String artCode) {
		this.artCode = artCode;
	}

	public String getArtDesc() {
		return this.artDesc;
	}

	public void setArtDesc(String artDesc) {
		this.artDesc = artDesc;
	}

	public String getMcCode() {
		return this.mcCode;
	}

	public void setMcCode(String mcCode) {
		this.mcCode = mcCode;
	}

	public String getMcDesc() {
		return this.mcDesc;
	}

	public void setMcDesc(String mcDesc) {
		this.mcDesc = mcDesc;
	}

	public MstProposal getMstProposal() {
		return this.mstProposal;
	}

	public void setMstProposal(MstProposal mstProposal) {
		this.mstProposal = mstProposal;
	}

}