package com.fks.pwm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fks.pwm.entity.Mch;
import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.entity.MstLeadTime;
import com.fks.pwm.entity.MstLocation;
import com.fks.pwm.entity.MstRole;
import com.fks.pwm.entity.MstStatus;
import com.fks.pwm.entity.MstStore;
import com.fks.pwm.repository.MCHRepo;
import com.fks.pwm.repository.MstEmployeeRepository;
import com.fks.pwm.repository.MstLeadTimeRepo;
import com.fks.pwm.repository.MstLocationRepo;
import com.fks.pwm.repository.MstStatusRepo;
import com.fks.pwm.repository.RoleRepo;
import com.fks.pwm.repository.StoreRepo;
import com.fks.pwm.util.CommonUtil;
import com.fks.pwm.vo.LeadTimeVO;
import com.fks.pwm.vo.MchVO;

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
	private MstEmployeeRepository empRepo;
	
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
	
	@Transactional(readOnly=false)
	public void createEmployee(MstEmployee emp){
		empRepo.save(emp);
	}
	
	public MstRole getRole(Long roleId){
		return roleRepo.findOne(roleId);
	}
	
	public List<MstEmployee> searchEmployeeByName(String empName){
		return empRepo.findAllEmployeesByName("%"+empName+"%");
	}
	
	
}
