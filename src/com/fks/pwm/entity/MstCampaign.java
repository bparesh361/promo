package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_campaign database table.
 * 
 */
@Entity
@Table(name="mst_campaign")
@NamedQuery(name="MstCampaign.findAll", query="SELECT m FROM MstCampaign m")
public class MstCampaign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="campaign_id")
	private String campaignId;

	@Column(name="campaign_name")
	private String campaignName;

	@Column(name="is_active")
	private byte isActive;

	//bi-directional many-to-one association to MstPromo
	@OneToMany(mappedBy="mstCampaign")
	private List<MstPromo> mstPromos;

	public MstCampaign() {
	}

	public String getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignName() {
		return this.campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public List<MstPromo> getMstPromos() {
		return this.mstPromos;
	}

	public void setMstPromos(List<MstPromo> mstPromos) {
		this.mstPromos = mstPromos;
	}

	public MstPromo addMstPromo(MstPromo mstPromo) {
		getMstPromos().add(mstPromo);
		mstPromo.setMstCampaign(this);

		return mstPromo;
	}

	public MstPromo removeMstPromo(MstPromo mstPromo) {
		getMstPromos().remove(mstPromo);
		mstPromo.setMstCampaign(null);

		return mstPromo;
	}

}