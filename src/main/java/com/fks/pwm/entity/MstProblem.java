package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_problem database table.
 * 
 */
@Entity
@Table(name="mst_problem")
@NamedQuery(name="MstProblem.findAll", query="SELECT m FROM MstProblem m")
public class MstProblem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="problem_type_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long problemTypeId;

	@Column(name="is_blocked")
	private byte isBlocked;

	@Column(name="problem_name")
	private String problemName;

	//bi-directional many-to-one association to MstProposal
	@OneToMany(mappedBy="mstProblem")
	private List<MstProposal> mstProposals;

	public MstProblem() {
	}

	public Long getProblemTypeId() {
		return this.problemTypeId;
	}

	public void setProblemTypeId(Long problemTypeId) {
		this.problemTypeId = problemTypeId;
	}

	public byte getIsBlocked() {
		return this.isBlocked;
	}

	public void setIsBlocked(byte isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getProblemName() {
		return this.problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	public List<MstProposal> getMstProposals() {
		return this.mstProposals;
	}

	public void setMstProposals(List<MstProposal> mstProposals) {
		this.mstProposals = mstProposals;
	}

	public MstProposal addMstProposal(MstProposal mstProposal) {
		getMstProposals().add(mstProposal);
		mstProposal.setMstProblem(this);

		return mstProposal;
	}

	public MstProposal removeMstProposal(MstProposal mstProposal) {
		getMstProposals().remove(mstProposal);
		mstProposal.setMstProblem(null);

		return mstProposal;
	}

}