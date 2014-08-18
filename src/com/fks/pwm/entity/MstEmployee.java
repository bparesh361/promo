package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the mst_employee database table.
 * 
 */
@Entity
@Table(name="mst_employee")
@NamedQuery(name="MstEmployee.findAll", query="SELECT m FROM MstEmployee m")
public class MstEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emp_id")
	private String empId;

	@Column(name="contact_no")
	private BigInteger contactNo;

	@Column(name="email_id")
	private String emailId;

	@Column(name="emp_code")
	private BigInteger empCode;

	@Column(name="emp_password")
	private String empPassword;

	@Column(name="employee_name")
	private String employeeName;

	private byte is_F6;

	@Column(name="is_password_change")
	private byte isPasswordChange;

	private byte isBlocked;

	@Column(name="reporting_person_name")
	private String reportingPersonName;

	@Column(name="store_desc")
	private String storeDesc;

	@Column(name="task_manager")
	private String taskManager;

	@Column(name="user_id")
	private String userId;

	//bi-directional many-to-one association to Map_user_MCH_F1
	@OneToMany(mappedBy="mstEmployee")
	private List<Map_user_MCH_F1> mapUserMchF1s;

	//bi-directional many-to-one association to Map_user_MCH_F2
	@OneToMany(mappedBy="mstEmployee")
	private List<Map_user_MCH_F2> mapUserMchF2s;

	//bi-directional many-to-one association to Map_user_MCH_F3
	@OneToMany(mappedBy="mstEmployee")
	private List<Map_user_MCH_F3> mapUserMchF3s;

	//bi-directional many-to-one association to Map_user_MCH_F5
	@OneToMany(mappedBy="mstEmployee")
	private List<Map_user_MCH_F5> mapUserMchF5s;

	//bi-directional many-to-one association to MapUserDepartment
	@OneToMany(mappedBy="mstEmployee")
	private List<MapUserDepartment> mapUserDepartments;

	//bi-directional many-to-one association to Mch
	@OneToMany(mappedBy="mstEmployee")
	private List<Mch> mches;

	//bi-directional many-to-one association to MstArticleSearch
	@OneToMany(mappedBy="mstEmployee")
	private List<MstArticleSearch> mstArticleSearches;

	//bi-directional many-to-one association to MstRole
	@ManyToOne
	@JoinColumn(name="mst_role_id")
	private MstRole mstRole;

	//bi-directional many-to-one association to MstStore
	@ManyToOne
	@JoinColumn(name="mst_store_id")
	private MstStore mstStore;

	//bi-directional many-to-one association to MstPromo
	@OneToMany(mappedBy="mstEmployee1")
	private List<MstPromo> mstPromos1;

	//bi-directional many-to-one association to MstPromo
	@OneToMany(mappedBy="mstEmployee2")
	private List<MstPromo> mstPromos2;

	//bi-directional many-to-one association to MstProposal
	@OneToMany(mappedBy="mstEmployee")
	private List<MstProposal> mstProposals;

	//bi-directional many-to-one association to MstRole
	@OneToMany(mappedBy="mstEmployee1")
	private List<MstRole> mstRoles1;

	//bi-directional many-to-one association to MstRole
	@OneToMany(mappedBy="mstEmployee2")
	private List<MstRole> mstRoles2;

	//bi-directional many-to-one association to MstStore
	@OneToMany(mappedBy="mstEmployee")
	private List<MstStore> mstStores;

	//bi-directional many-to-one association to TransPromo
	@OneToMany(mappedBy="mstEmployee1")
	private List<TransPromo> transPromos1;

	//bi-directional many-to-one association to TransPromo
	@OneToMany(mappedBy="mstEmployee2")
	private List<TransPromo> transPromos2;

	//bi-directional many-to-one association to TransPromo
	@OneToMany(mappedBy="mstEmployee3")
	private List<TransPromo> transPromos3;

	//bi-directional many-to-one association to TransPromo
	@OneToMany(mappedBy="mstEmployee4")
	private List<TransPromo> transPromos4;

	//bi-directional many-to-one association to TransPromo
	@OneToMany(mappedBy="mstEmployee5")
	private List<TransPromo> transPromos5;

	//bi-directional many-to-one association to TransPromo
	@OneToMany(mappedBy="mstEmployee6")
	private List<TransPromo> transPromos6;

	//bi-directional many-to-one association to TransPromo
	@OneToMany(mappedBy="mstEmployee7")
	private List<TransPromo> transPromos7;

	//bi-directional many-to-one association to TransPromoArticle
	@OneToMany(mappedBy="mstEmployee")
	private List<TransPromoArticle> transPromoArticles;

	//bi-directional many-to-one association to TransPromoMc
	@OneToMany(mappedBy="mstEmployee")
	private List<TransPromoMc> transPromoMcs;

	//bi-directional many-to-one association to TransPromoStatus
	@OneToMany(mappedBy="mstEmployee")
	private List<TransPromoStatus> transPromoStatuses;

	//bi-directional many-to-one association to TransTask
	@OneToMany(mappedBy="mstEmployee1")
	private List<TransTask> transTasks1;

	//bi-directional many-to-one association to TransTask
	@OneToMany(mappedBy="mstEmployee2")
	private List<TransTask> transTasks2;

	//bi-directional many-to-one association to TransTask
	@OneToMany(mappedBy="mstEmployee3")
	private List<TransTask> transTasks3;

	public MstEmployee() {
	}

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public BigInteger getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(BigInteger contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public BigInteger getEmpCode() {
		return this.empCode;
	}

	public void setEmpCode(BigInteger empCode) {
		this.empCode = empCode;
	}

	public String getEmpPassword() {
		return this.empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public byte getIs_F6() {
		return this.is_F6;
	}

	public void setIs_F6(byte is_F6) {
		this.is_F6 = is_F6;
	}

	public byte getIsPasswordChange() {
		return this.isPasswordChange;
	}

	public void setIsPasswordChange(byte isPasswordChange) {
		this.isPasswordChange = isPasswordChange;
	}

	public byte getIsBlocked() {
		return this.isBlocked;
	}

	public void setIsBlocked(byte isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getReportingPersonName() {
		return this.reportingPersonName;
	}

	public void setReportingPersonName(String reportingPersonName) {
		this.reportingPersonName = reportingPersonName;
	}

	public String getStoreDesc() {
		return this.storeDesc;
	}

	public void setStoreDesc(String storeDesc) {
		this.storeDesc = storeDesc;
	}

	public String getTaskManager() {
		return this.taskManager;
	}

	public void setTaskManager(String taskManager) {
		this.taskManager = taskManager;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Map_user_MCH_F1> getMapUserMchF1s() {
		return this.mapUserMchF1s;
	}

	public void setMapUserMchF1s(List<Map_user_MCH_F1> mapUserMchF1s) {
		this.mapUserMchF1s = mapUserMchF1s;
	}

	public Map_user_MCH_F1 addMapUserMchF1(Map_user_MCH_F1 mapUserMchF1) {
		getMapUserMchF1s().add(mapUserMchF1);
		mapUserMchF1.setMstEmployee(this);

		return mapUserMchF1;
	}

	public Map_user_MCH_F1 removeMapUserMchF1(Map_user_MCH_F1 mapUserMchF1) {
		getMapUserMchF1s().remove(mapUserMchF1);
		mapUserMchF1.setMstEmployee(null);

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
		mapUserMchF2.setMstEmployee(this);

		return mapUserMchF2;
	}

	public Map_user_MCH_F2 removeMapUserMchF2(Map_user_MCH_F2 mapUserMchF2) {
		getMapUserMchF2s().remove(mapUserMchF2);
		mapUserMchF2.setMstEmployee(null);

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
		mapUserMchF3.setMstEmployee(this);

		return mapUserMchF3;
	}

	public Map_user_MCH_F3 removeMapUserMchF3(Map_user_MCH_F3 mapUserMchF3) {
		getMapUserMchF3s().remove(mapUserMchF3);
		mapUserMchF3.setMstEmployee(null);

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
		mapUserMchF5.setMstEmployee(this);

		return mapUserMchF5;
	}

	public Map_user_MCH_F5 removeMapUserMchF5(Map_user_MCH_F5 mapUserMchF5) {
		getMapUserMchF5s().remove(mapUserMchF5);
		mapUserMchF5.setMstEmployee(null);

		return mapUserMchF5;
	}

	public List<MapUserDepartment> getMapUserDepartments() {
		return this.mapUserDepartments;
	}

	public void setMapUserDepartments(List<MapUserDepartment> mapUserDepartments) {
		this.mapUserDepartments = mapUserDepartments;
	}

	public MapUserDepartment addMapUserDepartment(MapUserDepartment mapUserDepartment) {
		getMapUserDepartments().add(mapUserDepartment);
		mapUserDepartment.setMstEmployee(this);

		return mapUserDepartment;
	}

	public MapUserDepartment removeMapUserDepartment(MapUserDepartment mapUserDepartment) {
		getMapUserDepartments().remove(mapUserDepartment);
		mapUserDepartment.setMstEmployee(null);

		return mapUserDepartment;
	}

	public List<Mch> getMches() {
		return this.mches;
	}

	public void setMches(List<Mch> mches) {
		this.mches = mches;
	}

	public Mch addMch(Mch mch) {
		getMches().add(mch);
		mch.setMstEmployee(this);

		return mch;
	}

	public Mch removeMch(Mch mch) {
		getMches().remove(mch);
		mch.setMstEmployee(null);

		return mch;
	}

	public List<MstArticleSearch> getMstArticleSearches() {
		return this.mstArticleSearches;
	}

	public void setMstArticleSearches(List<MstArticleSearch> mstArticleSearches) {
		this.mstArticleSearches = mstArticleSearches;
	}

	public MstArticleSearch addMstArticleSearch(MstArticleSearch mstArticleSearch) {
		getMstArticleSearches().add(mstArticleSearch);
		mstArticleSearch.setMstEmployee(this);

		return mstArticleSearch;
	}

	public MstArticleSearch removeMstArticleSearch(MstArticleSearch mstArticleSearch) {
		getMstArticleSearches().remove(mstArticleSearch);
		mstArticleSearch.setMstEmployee(null);

		return mstArticleSearch;
	}

	public MstRole getMstRole() {
		return this.mstRole;
	}

	public void setMstRole(MstRole mstRole) {
		this.mstRole = mstRole;
	}

	public MstStore getMstStore() {
		return this.mstStore;
	}

	public void setMstStore(MstStore mstStore) {
		this.mstStore = mstStore;
	}

	public List<MstPromo> getMstPromos1() {
		return this.mstPromos1;
	}

	public void setMstPromos1(List<MstPromo> mstPromos1) {
		this.mstPromos1 = mstPromos1;
	}

	public MstPromo addMstPromos1(MstPromo mstPromos1) {
		getMstPromos1().add(mstPromos1);
		mstPromos1.setMstEmployee1(this);

		return mstPromos1;
	}

	public MstPromo removeMstPromos1(MstPromo mstPromos1) {
		getMstPromos1().remove(mstPromos1);
		mstPromos1.setMstEmployee1(null);

		return mstPromos1;
	}

	public List<MstPromo> getMstPromos2() {
		return this.mstPromos2;
	}

	public void setMstPromos2(List<MstPromo> mstPromos2) {
		this.mstPromos2 = mstPromos2;
	}

	public MstPromo addMstPromos2(MstPromo mstPromos2) {
		getMstPromos2().add(mstPromos2);
		mstPromos2.setMstEmployee2(this);

		return mstPromos2;
	}

	public MstPromo removeMstPromos2(MstPromo mstPromos2) {
		getMstPromos2().remove(mstPromos2);
		mstPromos2.setMstEmployee2(null);

		return mstPromos2;
	}

	public List<MstProposal> getMstProposals() {
		return this.mstProposals;
	}

	public void setMstProposals(List<MstProposal> mstProposals) {
		this.mstProposals = mstProposals;
	}

	public MstProposal addMstProposal(MstProposal mstProposal) {
		getMstProposals().add(mstProposal);
		mstProposal.setMstEmployee(this);

		return mstProposal;
	}

	public MstProposal removeMstProposal(MstProposal mstProposal) {
		getMstProposals().remove(mstProposal);
		mstProposal.setMstEmployee(null);

		return mstProposal;
	}

	public List<MstRole> getMstRoles1() {
		return this.mstRoles1;
	}

	public void setMstRoles1(List<MstRole> mstRoles1) {
		this.mstRoles1 = mstRoles1;
	}

	public MstRole addMstRoles1(MstRole mstRoles1) {
		getMstRoles1().add(mstRoles1);
		mstRoles1.setMstEmployee1(this);

		return mstRoles1;
	}

	public MstRole removeMstRoles1(MstRole mstRoles1) {
		getMstRoles1().remove(mstRoles1);
		mstRoles1.setMstEmployee1(null);

		return mstRoles1;
	}

	public List<MstRole> getMstRoles2() {
		return this.mstRoles2;
	}

	public void setMstRoles2(List<MstRole> mstRoles2) {
		this.mstRoles2 = mstRoles2;
	}

	public MstRole addMstRoles2(MstRole mstRoles2) {
		getMstRoles2().add(mstRoles2);
		mstRoles2.setMstEmployee2(this);

		return mstRoles2;
	}

	public MstRole removeMstRoles2(MstRole mstRoles2) {
		getMstRoles2().remove(mstRoles2);
		mstRoles2.setMstEmployee2(null);

		return mstRoles2;
	}

	public List<MstStore> getMstStores() {
		return this.mstStores;
	}

	public void setMstStores(List<MstStore> mstStores) {
		this.mstStores = mstStores;
	}

	public MstStore addMstStore(MstStore mstStore) {
		getMstStores().add(mstStore);
		mstStore.setMstEmployee(this);

		return mstStore;
	}

	public MstStore removeMstStore(MstStore mstStore) {
		getMstStores().remove(mstStore);
		mstStore.setMstEmployee(null);

		return mstStore;
	}

	public List<TransPromo> getTransPromos1() {
		return this.transPromos1;
	}

	public void setTransPromos1(List<TransPromo> transPromos1) {
		this.transPromos1 = transPromos1;
	}

	public TransPromo addTransPromos1(TransPromo transPromos1) {
		getTransPromos1().add(transPromos1);
		transPromos1.setMstEmployee1(this);

		return transPromos1;
	}

	public TransPromo removeTransPromos1(TransPromo transPromos1) {
		getTransPromos1().remove(transPromos1);
		transPromos1.setMstEmployee1(null);

		return transPromos1;
	}

	public List<TransPromo> getTransPromos2() {
		return this.transPromos2;
	}

	public void setTransPromos2(List<TransPromo> transPromos2) {
		this.transPromos2 = transPromos2;
	}

	public TransPromo addTransPromos2(TransPromo transPromos2) {
		getTransPromos2().add(transPromos2);
		transPromos2.setMstEmployee2(this);

		return transPromos2;
	}

	public TransPromo removeTransPromos2(TransPromo transPromos2) {
		getTransPromos2().remove(transPromos2);
		transPromos2.setMstEmployee2(null);

		return transPromos2;
	}

	public List<TransPromo> getTransPromos3() {
		return this.transPromos3;
	}

	public void setTransPromos3(List<TransPromo> transPromos3) {
		this.transPromos3 = transPromos3;
	}

	public TransPromo addTransPromos3(TransPromo transPromos3) {
		getTransPromos3().add(transPromos3);
		transPromos3.setMstEmployee3(this);

		return transPromos3;
	}

	public TransPromo removeTransPromos3(TransPromo transPromos3) {
		getTransPromos3().remove(transPromos3);
		transPromos3.setMstEmployee3(null);

		return transPromos3;
	}

	public List<TransPromo> getTransPromos4() {
		return this.transPromos4;
	}

	public void setTransPromos4(List<TransPromo> transPromos4) {
		this.transPromos4 = transPromos4;
	}

	public TransPromo addTransPromos4(TransPromo transPromos4) {
		getTransPromos4().add(transPromos4);
		transPromos4.setMstEmployee4(this);

		return transPromos4;
	}

	public TransPromo removeTransPromos4(TransPromo transPromos4) {
		getTransPromos4().remove(transPromos4);
		transPromos4.setMstEmployee4(null);

		return transPromos4;
	}

	public List<TransPromo> getTransPromos5() {
		return this.transPromos5;
	}

	public void setTransPromos5(List<TransPromo> transPromos5) {
		this.transPromos5 = transPromos5;
	}

	public TransPromo addTransPromos5(TransPromo transPromos5) {
		getTransPromos5().add(transPromos5);
		transPromos5.setMstEmployee5(this);

		return transPromos5;
	}

	public TransPromo removeTransPromos5(TransPromo transPromos5) {
		getTransPromos5().remove(transPromos5);
		transPromos5.setMstEmployee5(null);

		return transPromos5;
	}

	public List<TransPromo> getTransPromos6() {
		return this.transPromos6;
	}

	public void setTransPromos6(List<TransPromo> transPromos6) {
		this.transPromos6 = transPromos6;
	}

	public TransPromo addTransPromos6(TransPromo transPromos6) {
		getTransPromos6().add(transPromos6);
		transPromos6.setMstEmployee6(this);

		return transPromos6;
	}

	public TransPromo removeTransPromos6(TransPromo transPromos6) {
		getTransPromos6().remove(transPromos6);
		transPromos6.setMstEmployee6(null);

		return transPromos6;
	}

	public List<TransPromo> getTransPromos7() {
		return this.transPromos7;
	}

	public void setTransPromos7(List<TransPromo> transPromos7) {
		this.transPromos7 = transPromos7;
	}

	public TransPromo addTransPromos7(TransPromo transPromos7) {
		getTransPromos7().add(transPromos7);
		transPromos7.setMstEmployee7(this);

		return transPromos7;
	}

	public TransPromo removeTransPromos7(TransPromo transPromos7) {
		getTransPromos7().remove(transPromos7);
		transPromos7.setMstEmployee7(null);

		return transPromos7;
	}

	public List<TransPromoArticle> getTransPromoArticles() {
		return this.transPromoArticles;
	}

	public void setTransPromoArticles(List<TransPromoArticle> transPromoArticles) {
		this.transPromoArticles = transPromoArticles;
	}

	public TransPromoArticle addTransPromoArticle(TransPromoArticle transPromoArticle) {
		getTransPromoArticles().add(transPromoArticle);
		transPromoArticle.setMstEmployee(this);

		return transPromoArticle;
	}

	public TransPromoArticle removeTransPromoArticle(TransPromoArticle transPromoArticle) {
		getTransPromoArticles().remove(transPromoArticle);
		transPromoArticle.setMstEmployee(null);

		return transPromoArticle;
	}

	public List<TransPromoMc> getTransPromoMcs() {
		return this.transPromoMcs;
	}

	public void setTransPromoMcs(List<TransPromoMc> transPromoMcs) {
		this.transPromoMcs = transPromoMcs;
	}

	public TransPromoMc addTransPromoMc(TransPromoMc transPromoMc) {
		getTransPromoMcs().add(transPromoMc);
		transPromoMc.setMstEmployee(this);

		return transPromoMc;
	}

	public TransPromoMc removeTransPromoMc(TransPromoMc transPromoMc) {
		getTransPromoMcs().remove(transPromoMc);
		transPromoMc.setMstEmployee(null);

		return transPromoMc;
	}

	public List<TransPromoStatus> getTransPromoStatuses() {
		return this.transPromoStatuses;
	}

	public void setTransPromoStatuses(List<TransPromoStatus> transPromoStatuses) {
		this.transPromoStatuses = transPromoStatuses;
	}

	public TransPromoStatus addTransPromoStatus(TransPromoStatus transPromoStatus) {
		getTransPromoStatuses().add(transPromoStatus);
		transPromoStatus.setMstEmployee(this);

		return transPromoStatus;
	}

	public TransPromoStatus removeTransPromoStatus(TransPromoStatus transPromoStatus) {
		getTransPromoStatuses().remove(transPromoStatus);
		transPromoStatus.setMstEmployee(null);

		return transPromoStatus;
	}

	public List<TransTask> getTransTasks1() {
		return this.transTasks1;
	}

	public void setTransTasks1(List<TransTask> transTasks1) {
		this.transTasks1 = transTasks1;
	}

	public TransTask addTransTasks1(TransTask transTasks1) {
		getTransTasks1().add(transTasks1);
		transTasks1.setMstEmployee1(this);

		return transTasks1;
	}

	public TransTask removeTransTasks1(TransTask transTasks1) {
		getTransTasks1().remove(transTasks1);
		transTasks1.setMstEmployee1(null);

		return transTasks1;
	}

	public List<TransTask> getTransTasks2() {
		return this.transTasks2;
	}

	public void setTransTasks2(List<TransTask> transTasks2) {
		this.transTasks2 = transTasks2;
	}

	public TransTask addTransTasks2(TransTask transTasks2) {
		getTransTasks2().add(transTasks2);
		transTasks2.setMstEmployee2(this);

		return transTasks2;
	}

	public TransTask removeTransTasks2(TransTask transTasks2) {
		getTransTasks2().remove(transTasks2);
		transTasks2.setMstEmployee2(null);

		return transTasks2;
	}

	public List<TransTask> getTransTasks3() {
		return this.transTasks3;
	}

	public void setTransTasks3(List<TransTask> transTasks3) {
		this.transTasks3 = transTasks3;
	}

	public TransTask addTransTasks3(TransTask transTasks3) {
		getTransTasks3().add(transTasks3);
		transTasks3.setMstEmployee3(this);

		return transTasks3;
	}

	public TransTask removeTransTasks3(TransTask transTasks3) {
		getTransTasks3().remove(transTasks3);
		transTasks3.setMstEmployee3(null);

		return transTasks3;
	}

}