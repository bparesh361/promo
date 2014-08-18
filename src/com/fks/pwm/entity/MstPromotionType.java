package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_promotion_type database table.
 * 
 */
@Entity
@Table(name="mst_promotion_type")
@NamedQuery(name="MstPromotionType.findAll", query="SELECT m FROM MstPromotionType m")
public class MstPromotionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="promo_type_id")
	private String promoTypeId;

	@Column(name="is_blocked")
	private byte isBlocked;

	@Column(name="promo_type_name")
	private String promoTypeName;

	//bi-directional many-to-one association to MstProposal
	@OneToMany(mappedBy="mstPromotionType")
	private List<MstProposal> mstProposals;

	//bi-directional many-to-one association to TransPromo
	@OneToMany(mappedBy="mstPromotionType")
	private List<TransPromo> transPromos;

	public MstPromotionType() {
	}

	public String getPromoTypeId() {
		return this.promoTypeId;
	}

	public void setPromoTypeId(String promoTypeId) {
		this.promoTypeId = promoTypeId;
	}

	public byte getIsBlocked() {
		return this.isBlocked;
	}

	public void setIsBlocked(byte isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getPromoTypeName() {
		return this.promoTypeName;
	}

	public void setPromoTypeName(String promoTypeName) {
		this.promoTypeName = promoTypeName;
	}

	public List<MstProposal> getMstProposals() {
		return this.mstProposals;
	}

	public void setMstProposals(List<MstProposal> mstProposals) {
		this.mstProposals = mstProposals;
	}

	public MstProposal addMstProposal(MstProposal mstProposal) {
		getMstProposals().add(mstProposal);
		mstProposal.setMstPromotionType(this);

		return mstProposal;
	}

	public MstProposal removeMstProposal(MstProposal mstProposal) {
		getMstProposals().remove(mstProposal);
		mstProposal.setMstPromotionType(null);

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
		transPromo.setMstPromotionType(this);

		return transPromo;
	}

	public TransPromo removeTransPromo(TransPromo transPromo) {
		getTransPromos().remove(transPromo);
		transPromo.setMstPromotionType(null);

		return transPromo;
	}

}