package com.fks.pwm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fks.pwm.entity.Map_user_MCH_F1;
import com.fks.pwm.entity.Map_user_MCH_F2;
import com.fks.pwm.entity.Map_user_MCH_F3;
import com.fks.pwm.entity.Mch;
import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.entity.MstLeadTime;
import com.fks.pwm.entity.MstLocation;
import com.fks.pwm.entity.MstRole;
import com.fks.pwm.entity.MstStatus;
import com.fks.pwm.entity.MstStore;
import com.fks.pwm.entity.MstZone;
import com.fks.pwm.repository.MCHRepo;
import com.fks.pwm.repository.MapUserMchF1Repo;
import com.fks.pwm.repository.MapUserMchF2Repo;
import com.fks.pwm.repository.MapUserMchF3Repo;
import com.fks.pwm.repository.MstEmployeeRepository;
import com.fks.pwm.repository.MstLeadTimeRepo;
import com.fks.pwm.repository.MstLocationRepo;
import com.fks.pwm.repository.MstStatusRepo;
import com.fks.pwm.repository.RoleRepo;
import com.fks.pwm.repository.StoreRepo;
import com.fks.pwm.repository.ZoneRepo;
import com.fks.pwm.util.CommonUtil;
import com.fks.pwm.vo.LeadTimeVO;
import com.fks.pwm.vo.MchVO;
import com.fks.pwm.vo.UserVO;

@Service
@Transactional(readOnly=true)
public class MasterService {
	
	@Autowired
	private MstStatusRepo statusRepo;
	
	@Autowired
	private MstLeadTimeRepo leadTimeRepo;
	
	@Autowired
	private MCHRepo mchRepo;
	
	@Autowired
	private MstLocationRepo locationRepo;
	
	@Autowired
	private StoreRepo storeRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private ZoneRepo zoneRepo;
	
	@Autowired
	private MstEmployeeRepository empRepo;
	
	@Autowired
	private MapUserMchF1Repo mchf1Repo;
	
	@Autowired
	private MapUserMchF2Repo mchf2Repo;
	
	@Autowired
	private MapUserMchF3Repo mchf3Repo;
	
	public List<MstStatus> getLeadTimeFromMstStatus(){
		List<MstStatus> listStatus = new ArrayList<MstStatus>(2);
		listStatus.add(statusRepo.findOne(new Long(1)));
		listStatus.add(statusRepo.findOne(new Long(2)));
		return listStatus;
	}
	
	public List<MstLeadTime> getLeadTime(){
		return leadTimeRepo.findAll();
	}
	
	@Transactional(readOnly=false)
	public void updateLeadTime(LeadTimeVO vo){
		MstStatus status = statusRepo.findOne(vo.getId());
		if(status!=null){
			status.setL1(vo.getL1());
			status.setL2(vo.getL2());
			status.setL5(vo.getL5());
		}
	}
	
	@Transactional(readOnly=false)
	public void updatePromoLeadTime(int value){
		MstLeadTime leadTime = leadTimeRepo.findOne(new Long(1));
		if(leadTime!=null){
			leadTime.setValue(value);
		}
	}
	
	public List<Mch> getAllMCH(){
		return mchRepo.findAll();
	}
	
	@Transactional(readOnly=false)
	public boolean updateMCH(MchVO mchvo, MstEmployee emp){
		if(mchvo==null || emp==null){
			return false;
		}
		Mch mchdb = mchRepo.findOne(mchvo.getMcCode());
		List<MstLocation> list = locationRepo.findByLocationName(mchvo.getLocation());
		if(list==null || list.size()==0){
			return false;
		}
		if(mchdb==null){
			Mch mch = CommonUtil.getMCH(mchvo,emp);
			mch.setMstLocation(list.get(0));
			mch.setUpdatedDate(new Date());
			mchRepo.save(mch);
		} else {
			mchdb.setCategoryName(mchvo.getCategoryName());
			mchdb.setMcName(mchvo.getMcName());
			mchdb.setSubCategoryName(mchvo.getSubCategoryName());
			mchdb.setMstLocation(list.get(0));
			mchdb.setUpdatedDate(new Date());
		}
		return true;
	}	
	
	public List<MstStore> getSites(Long locationId){
		return storeRepo.getAllStoresByLocationId(locationId);
	}
	
	public MstStore getStore(String storeCode) {
		return storeRepo.findOne(storeCode);
	}
	
	public List<MstRole> findAllRoles() {
		return roleRepo.findAll(); 
	}
	
	public List<MstLocation> findAllLocations() {
		return locationRepo.findAll(); 
	}
	
	public List<MstZone> findAllZones(){
		return zoneRepo.findAll();
	}
	
	
	
	@Transactional(readOnly=false)
	public void createEmployee(MstEmployee emp){		
		empRepo.save(emp);
	}
	
	@Transactional(readOnly=false)
	public void updateEmployee(UserVO vo, MstRole role, MstStore store){
		MstEmployee emp = searchEmployeeById(Long.parseLong(vo.getEmpCode()));
		CommonUtil.getEmployeeFromVO(vo, role, store,emp);
	}
	
	
	
	public MstRole getRole(Long roleId){
		return roleRepo.findOne(roleId);
	}
	
	public List<MstEmployee> searchEmployeeByName(String empName){
		return empRepo.findAllEmployeesByName("%"+empName+"%");
	}
	
	public List<MstStore> getStoresByName(String storeName){
		return storeRepo.findAllStoresByName("%"+storeName+"%");
	}
	
	public MstEmployee searchEmployeeById(Long empId){
		return empRepo.findOne(empId);
	}	
	
	public List<MstEmployee> searchEmployeeByZone(Long zoneId){
		return empRepo.findAllEmployeesByZone(zoneId);
	}
	
	public List<MstEmployee> searchEmployeeByLocation(Long locationId){
		return empRepo.findAllEmployeesByZone(locationId);
	}
	
	public List<MstEmployee> searchEmployeeByRole(Long roleId){
		return empRepo.findAllEmployeesByRole(roleId);
	}
	
	public List<MstEmployee> searchEmployeeBySiteId(String siteId){
		return empRepo.findAllEmployeesByStoreId(siteId);		
	} 
	
	public List<MstEmployee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	public MstEmployee getEmpF1Info(Long empId){
		MstEmployee emp = empRepo.findOne(empId);
		emp.getMapUserMchF1s().size();
		return emp;
	}
	
	public MstEmployee getEmpF2Info(Long empId){
		MstEmployee emp = empRepo.findOne(empId);
		emp.getMapUserMchF2s().size();
		return emp;
	}
	
	public MstEmployee getEmpF3Info(Long empId){
		MstEmployee emp = empRepo.findOne(empId);
		emp.getMapUserMchF3s().size();
		return emp;
	}
	
	@Transactional(readOnly=false)
	public boolean updateEmployeeMCH(List<String> mcCodeList, int type, Long empCode){
		MstEmployee emp = empRepo.findOne(empCode);
		if(emp==null){
			return false;
		}
		List<Mch> list = new ArrayList<Mch>();
		for(String mcCode : mcCodeList){
			Mch mch = mchRepo.findOne(mcCode);
			if(mch!=null){
				list.add(mch);
			}
		}
		if(type==1){
			for(Map_user_MCH_F1 mapUserMCHF1 :emp.getMapUserMchF1s()) {
				mchf1Repo.delete(mapUserMCHF1);
			}
			List<Map_user_MCH_F1> userF1List = new ArrayList<Map_user_MCH_F1>();
			for(Mch mch : list){
				Map_user_MCH_F1 userf1 = new Map_user_MCH_F1();
				userf1.setMstEmployee(emp);
				userf1.setMch(mch);
				userF1List.add(userf1);
			}
			emp.setMapUserMchF1s(userF1List);
		}else if(type==2){
			for(Map_user_MCH_F2 mapUserMCHF2 :emp.getMapUserMchF2s()) {
				mchf2Repo.delete(mapUserMCHF2);
			}
			List<Map_user_MCH_F2> userF2List = new ArrayList<Map_user_MCH_F2>();
			for(Mch mch : list){
				Map_user_MCH_F2 userf2 = new Map_user_MCH_F2();
				userf2.setMstEmployee(emp);
				userf2.setMch(mch);
				userF2List.add(userf2);
			}
			emp.setMapUserMchF2s(userF2List);
		} else {
			for(Map_user_MCH_F3 mapUserMCHF3 :emp.getMapUserMchF3s()) {
				mchf3Repo.delete(mapUserMCHF3);
			}
			List<Map_user_MCH_F3> userF3List = new ArrayList<Map_user_MCH_F3>();
			for(Mch mch : list){
				Map_user_MCH_F3 userf3 = new Map_user_MCH_F3();
				userf3.setMstEmployee(emp);
				userf3.setMch(mch);
				userF3List.add(userf3);
			}
			emp.setMapUserMchF3s(userF3List);
		}
		return true;
	}	
}
