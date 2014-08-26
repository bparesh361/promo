package com.fks.pwm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fks.pwm.entity.MapModuleProfile;
import com.fks.pwm.entity.MapRoleLocation;
import com.fks.pwm.entity.MapRoleProfile;
import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.entity.MstLocation;
import com.fks.pwm.entity.MstModule;
import com.fks.pwm.entity.MstProfile;
import com.fks.pwm.entity.MstRole;
import com.fks.pwm.repository.MapModuleProfileRepo;
import com.fks.pwm.repository.MapRoleLocationRepo;
import com.fks.pwm.repository.MapRoleProfileRepo;
import com.fks.pwm.repository.MstLocationRepo;
import com.fks.pwm.repository.MstModuleRepo;
import com.fks.pwm.repository.ProfileRepo;
import com.fks.pwm.repository.RoleRepo;

@Service
@Transactional
public class RoleProfileService {

	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@Autowired
	private MstLocationRepo locationRepo;
	
	@Autowired
	private MapRoleLocationRepo mapRoleLocationRepo;
	
	@Autowired
	private MapRoleProfileRepo mapRoleProfileRepo;
	
	@Autowired
	private MstModuleRepo moduleRepo;
	
	@Autowired
	private MapModuleProfileRepo moduleProfileRepo;
	
	public List<MstRole> getAllRoles(){
		return roleRepo.findAll();
	}
	
	@Transactional(readOnly=true)
	public List<MstProfile> getAllProfile(){
		return profileRepo.findAll();
	}	
	
	public MstRole creatUpdateRole(String roleName, String isBlocked, Long roleId, MstEmployee emp) {
		MstRole role = null;
		if(roleId==null){
			role = new MstRole();							
			role.setMstEmployee1(emp);
			role.setCreatedDate(new Date());
		} else {
			role = roleRepo.findOne(roleId);			
		}
		role.setRoleName(roleName);
		if(isBlocked.equals("0")){
			role.setIsActive(new Byte("0"));
		} else {
			role.setIsActive(new Byte("1"));
		}
		role.setUpdatedDate(new Date());		
		role.setUpdatedDate(new Date());
		if(roleId==null){
			roleRepo.save(role);
		} 
		return role;
	}
	
	@Transactional(readOnly=true)
	public List<MstRole> getRolesByName(String roleName){
		return roleRepo.findAllRolesByName("%"+roleName+"%");
	}
	
	@Transactional(readOnly=true)
	public MstRole getRoleById(Long roleId){
		MstRole role = roleRepo.findOne(roleId);
		role.getMapRoleProfiles().size();
		role.getMapRoleLocations().size();
		return role;
	}
	
	public void updateRoleProfileLocation(Long roleId, Long locationId, String profileIds){
		MstRole role = roleRepo.findOne(roleId);
		for(MapRoleLocation roleLocation : role.getMapRoleLocations()){
			mapRoleLocationRepo.delete(roleLocation);
		}		
		MstLocation location = locationRepo.findOne(locationId);
		MapRoleLocation roleLocation = new MapRoleLocation();
		roleLocation.setMstLocation(location);
		roleLocation.setMstRole(role);
		List<MapRoleLocation> list = new ArrayList<MapRoleLocation>();
		list.add(roleLocation);
		role.setMapRoleLocations(list);
		// role profile updates
		for(MapRoleProfile roleProfile : role.getMapRoleProfiles()){
			mapRoleProfileRepo.delete(roleProfile);
		}
		StringTokenizer tokenizer = new StringTokenizer(profileIds,",");
		List<MapRoleProfile> roleProfileList = new ArrayList<MapRoleProfile>();
		while(tokenizer.hasMoreTokens()){
			MapRoleProfile roleProfile = new MapRoleProfile();
			MstProfile profile = profileRepo.findOne(Long.parseLong(tokenizer.nextToken()));
			roleProfile.setMstProfile(profile);
			roleProfile.setMstRole(role);
			roleProfileList.add(roleProfile);
		}	
		role.setMapRoleProfiles(roleProfileList);
	}
	
	public List<MstModule> getAllModules(){
		return moduleRepo.findAll();
	}
	
	public List<MapModuleProfile> getAllModulesByProfileId(Long profileId){
		return moduleProfileRepo.getAllModuleProfileByProfileId(profileId);
	}
	
	public void updateModuleProfile(String moduleIds, Long profileId) {
		MstProfile profile = profileRepo.findOne(profileId);
		List<MapModuleProfile> list = moduleProfileRepo.getAllModuleProfileByProfileId(profileId);
		for(MapModuleProfile moduleProfile : list){
			moduleProfileRepo.delete(moduleProfile);
		}
		StringTokenizer tokenizer = new StringTokenizer(moduleIds,",");
		List<MapModuleProfile> moduleProfileList = new ArrayList<MapModuleProfile>();
		while(tokenizer.hasMoreTokens()){
			MstModule module = moduleRepo.findOne(Long.parseLong(tokenizer.nextToken()));
			MapModuleProfile moduleProfile = new MapModuleProfile();
			moduleProfile.setMstModule(module);
			moduleProfile.setMstProfile(profile);
			moduleProfileList.add(moduleProfile);
		}
		profile.setMapModuleProfiles(moduleProfileList);
	}
	
}
