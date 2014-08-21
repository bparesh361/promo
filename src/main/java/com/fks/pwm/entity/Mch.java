package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mch database table.
 * 
 */
@Entity
@Table(name="mch")
@NamedQuery(name="Mch.findAll", query="SELECT m FROM Mch m")
public class Mch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mc_code")
	private String mcCode;

	@Column(name="category_name")
	private String categoryName;

	@Column(name="is_blocked")
	private byte isBlocked;

	@Column(name="mc_name")
	private String mcName;

	@Column(name="sub_category_name")
	private String subCategoryName;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to MapPromoMch
	@OneToMany(mappedBy="mch")
	private List<MapPromoMch> mapPromoMches;

	//bi-directional many-to-one association to MapRoleMch
	@OneToMany(mappedBy="mch")
	private List<MapRoleMch> mapRoleMches;

	//bi-directional many-to-one association to Map_user_MCH_F1
	@OneToMany(mappedBy="mch")
	private List<Map_user_MCH_F1> mapUserMchF1s;

	//bi-directional many-to-one association to Map_user_MCH_F2
	@OneToMany(mappedBy="mch")
	private List<Map_user_MCH_F2> mapUserMchF2s;

	//bi-directional many-to-one association to Map_user_MCH_F3
	@OneToMany(mappedBy="mch")
	private List<Map_user_MCH_F3> mapUserMchF3s;

	//bi-directional many-to-one association to Map_user_MCH_F5
	@OneToMany(mappedBy="mch")
	private List<Map_user_MCH_F5> mapUserMchF5s;

	//bi-directional many-to-one association to MstLocation
	@ManyToOne
	@JoinColumn(name="location_id")
	private MstLocation mstLocation;

	//bi-directional many-to-one association to MstEmployee
	@ManyToOne
	@JoinColumn(name="created_by")
	private MstEmployee mstEmployee;

	//bi-directional many-to-one association to TransPromoMc
	@OneToMany(mappedBy="mch")
	private List<TransPromoMc> transPromoMcs;

	public Mch() {
	}

	public String getMcCode() {
		return this.mcCode;
	}

	public void setMcCode(String mcCode) {
		this.mcCode = mcCode;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public byte getIsBlocked() {
		return this.isBlocked;
	}

	public void setIsBlocked(byte isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getMcName() {
		return this.mcName;
	}

	public void setMcName(String mcName) {
		this.mcName = mcName;
	}

	public String getSubCategoryName() {
		return this.subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<MapPromoMch> getMapPromoMches() {
		return this.mapPromoMches;
	}

	public void setMapPromoMches(List<MapPromoMch> mapPromoMches) {
		this.mapPromoMches = mapPromoMches;
	}

	public MapPromoMch addMapPromoMch(MapPromoMch mapPromoMch) {
		getMapPromoMches().add(mapPromoMch);
		mapPromoMch.setMch(this);

		return mapPromoMch;
	}

	public MapPromoMch removeMapPromoMch(MapPromoMch mapPromoMch) {
		getMapPromoMches().remove(mapPromoMch);
		mapPromoMch.setMch(null);

		return mapPromoMch;
	}

	public List<MapRoleMch> getMapRoleMches() {
		return this.mapRoleMches;
	}

	public void setMapRoleMches(List<MapRoleMch> mapRoleMches) {
		this.mapRoleMches = mapRoleMches;
	}

	public MapRoleMch addMapRoleMch(MapRoleMch mapRoleMch) {
		getMapRoleMches().add(mapRoleMch);
		mapRoleMch.setMch(this);

		return mapRoleMch;
	}

	public MapRoleMch removeMapRoleMch(MapRoleMch mapRoleMch) {
		getMapRoleMches().remove(mapRoleMch);
		mapRoleMch.setMch(null);

		return mapRoleMch;
	}

	public List<Map_user_MCH_F1> getMapUserMchF1s() {
		return this.mapUserMchF1s;
	}

	public void setMapUserMchF1s(List<Map_user_MCH_F1> mapUserMchF1s) {
		this.mapUserMchF1s = mapUserMchF1s;
	}

	public Map_user_MCH_F1 addMapUserMchF1(Map_user_MCH_F1 mapUserMchF1) {
		getMapUserMchF1s().add(mapUserMchF1);
		mapUserMchF1.setMch(this);

		return mapUserMchF1;
	}

	public Map_user_MCH_F1 removeMapUserMchF1(Map_user_MCH_F1 mapUserMchF1) {
		getMapUserMchF1s().remove(mapUserMchF1);
		mapUserMchF1.setMch(null);

		return mapUserMchF1;
	}

	public List<Map_user_MCH_F2> getMapUserMchF2s() {
		return this.mapUserMchF2s;
	}

	public void setMapUserMchF2s(List<Map_user_MCH_F2> mapUserMchF2s) {
		this.mapUserMchF2s = mapUserMchF2s;
	}

	public Map_user_MCH_F2 addMapUserMchF2(Map_user_MCH_F2 mapUserMchF2) {
		getMapUserMchF2s().add(mapUserMchF2);
		mapUserMchF2.setMch(this);

		return mapUserMchF2;
	}

	public Map_user_MCH_F2 removeMapUserMchF2(Map_user_MCH_F2 mapUserMchF2) {
		getMapUserMchF2s().remove(mapUserMchF2);
		mapUserMchF2.setMch(null);

		return mapUserMchF2;
	}

	public List<Map_user_MCH_F3> getMapUserMchF3s() {
		return this.mapUserMchF3s;
	}

	public void setMapUserMchF3s(List<Map_user_MCH_F3> mapUserMchF3s) {
		this.mapUserMchF3s = mapUserMchF3s;
	}

	public Map_user_MCH_F3 addMapUserMchF3(Map_user_MCH_F3 mapUserMchF3) {
		getMapUserMchF3s().add(mapUserMchF3);
		mapUserMchF3.setMch(this);

		return mapUserMchF3;
	}

	public Map_user_MCH_F3 removeMapUserMchF3(Map_user_MCH_F3 mapUserMchF3) {
		getMapUserMchF3s().remove(mapUserMchF3);
		mapUserMchF3.setMch(null);

		return mapUserMchF3;
	}

	public List<Map_user_MCH_F5> getMapUserMchF5s() {
		return this.mapUserMchF5s;
	}

	public void setMapUserMchF5s(List<Map_user_MCH_F5> mapUserMchF5s) {
		this.mapUserMchF5s = mapUserMchF5s;
	}

	public Map_user_MCH_F5 addMapUserMchF5(Map_user_MCH_F5 mapUserMchF5) {
		getMapUserMchF5s().add(mapUserMchF5);
		mapUserMchF5.setMch(this);

		return mapUserMchF5;
	}

	public Map_user_MCH_F5 removeMapUserMchF5(Map_user_MCH_F5 mapUserMchF5) {
		getMapUserMchF5s().remove(mapUserMchF5);
		mapUserMchF5.setMch(null);

		return mapUserMchF5;
	}

	public MstLocation getMstLocation() {
		return this.mstLocation;
	}

	public void setMstLocation(MstLocation mstLocation) {
		this.mstLocation = mstLocation;
	}

	public MstEmployee getMstEmployee() {
		return this.mstEmployee;
	}

	public void setMstEmployee(MstEmployee mstEmployee) {
		this.mstEmployee = mstEmployee;
	}

	public List<TransPromoMc> getTransPromoMcs() {
		return this.transPromoMcs;
	}

	public void setTransPromoMcs(List<TransPromoMc> transPromoMcs) {
		this.transPromoMcs = transPromoMcs;
	}

	public TransPromoMc addTransPromoMc(TransPromoMc transPromoMc) {
		getTransPromoMcs().add(transPromoMc);
		transPromoMc.setMch(this);

		return transPromoMc;
	}

	public TransPromoMc removeTransPromoMc(TransPromoMc transPromoMc) {
		getTransPromoMcs().remove(transPromoMc);
		transPromoMc.setMch(null);

		return transPromoMc;
	}

}