package com.fks.pwm.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fks.pwm.entity.MapModuleProfile;
import com.fks.pwm.entity.MapRoleProfile;
import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.repository.MstEmployeeRepository;

@Service
@Transactional(readOnly = true)
public class LoginService {

	@Autowired
	private MstEmployeeRepository empRepo;
	
	@Autowired
	private EmailService emailService;

	public MstEmployee authenticate(String userName, String pwd) {
		List<MstEmployee> list = empRepo.findByUserId(userName);
		for (MstEmployee emp : list) {
			if (emp.getEmpPassword().equals(pwd)) {
				/*for (MapRoleProfile mapRoleProfile : emp.getMstRole()
						.getMapRoleProfiles()) {
					List<MapModuleProfile> mplist = mapRoleProfile
							.getMstProfile().getMapModuleProfiles();
					for (MapModuleProfile mapModuleProfile : mplist) {
					}
				}*/
				return emp;
			}
		}
		return null;
	}

	public Map<String,String> getModules(MstEmployee emp) {
		emp = empRepo.getOne(emp.getEmpId());
		TreeMap<String,String> map = new TreeMap<String, String>();
		for (MapRoleProfile mapRoleProfile : emp.getMstRole()
				.getMapRoleProfiles()) {
			List<MapModuleProfile> mplist = mapRoleProfile.getMstProfile()
					.getMapModuleProfiles();
			for (MapModuleProfile mapModuleProfile : mplist) {
				map.put(mapModuleProfile.getMstModule().getModuleId().toString(), mapModuleProfile.getMstModule().getModuleName());
			}
		}
		return map;

	}
	
	public void changePassword(Long empId, String newPassword){
		MstEmployee emp = empRepo.findOne(empId);
		emp.setEmpPassword(newPassword);
	}
	
	public String forgotPassword(String empId){
		List<MstEmployee> emp = empRepo.findByUserId(empId);
		if(emp==null || emp.size()==0){
			return "User Id does not Exist";
		}		
		emailService.sendForgotPasswordMsg(emp.get(0).getEmailId(), emp.get(0).getEmpPassword(), emp.get(0).getEmpCode());
		return " Success !!! Password Sent to email Id " + emp.get(0).getEmailId();		
	}

}
