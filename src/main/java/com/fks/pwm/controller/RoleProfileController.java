package com.fks.pwm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fks.pwm.entity.MapModuleProfile;
import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.entity.MstModule;
import com.fks.pwm.entity.MstProfile;
import com.fks.pwm.entity.MstRole;
import com.fks.pwm.service.RoleProfileService;
import com.fks.pwm.util.MasterJSONUtil;

@Controller
public class RoleProfileController {

	@Autowired
	private RoleProfileService roleProfileService;
	
	
	@RequestMapping("/rolePage")
	public String showRolePage(){
		return "master/role";
	}
	
	@RequestMapping("/profilePage")
	public String showProfilePage(){
		return "master/roleprofile";
	}
	
	@RequestMapping("/modulePage")
	public String showRoleProfileMappingPage(){
		return "master/module";
	}
	
	@RequestMapping("getAllRoles")
	public void getAllRoles(HttpServletResponse response) throws Exception {
		 List<MstRole> list = roleProfileService.getAllRoles();
		 JSONObject obj = MasterJSONUtil.getJsonForRolePage(list);
		 response.getWriter().print(obj);		 
	}
	
	@RequestMapping("getAllProfiles")
	public void getAllProfiles(HttpServletResponse response) throws Exception {
		 List<MstProfile> list = roleProfileService.getAllProfile();
		 JSONObject obj = MasterJSONUtil.getJsonForProfilePage(list);
		 response.getWriter().print(obj);		 
	}
	
	@RequestMapping("showProfiles")
	public void showProfilesDropDown(HttpServletResponse response) throws Exception {
		List<MstProfile> list = roleProfileService.getAllProfile();
		JSONObject obj = MasterJSONUtil.getJsonForProfileDropDown(list);
		response.getWriter().print(obj);
	}
	
	@RequestMapping("flexBoxRoles.do")
	public void getAllRoles(@RequestParam String flexRoleName, HttpServletResponse response) throws Exception{
		List<MstRole> roles = roleProfileService.getRolesByName(flexRoleName);
		JSONObject obj = MasterJSONUtil.getJsonForRoleFlexBox(roles);
		response.getWriter().print(obj);
	}
	
	
	@RequestMapping(value="saveUpdateRole",method=RequestMethod.POST)
	public String saveUpdateRole(@RequestParam String txtuserRole, @RequestParam String selStatus, @RequestParam(required=false) Long txtroleID, HttpSession session, HttpServletRequest request){
		MstEmployee emp = (MstEmployee)session.getAttribute("emp");
		MstRole role = roleProfileService.creatUpdateRole(txtuserRole, selStatus, txtroleID, emp);
		request.setAttribute("msg", "Role Created / Updated Successfully with Id " + role.getMstRoleId());
		return "master/roleprofile";
	}
	
	@RequestMapping("getRoleLocationProfileDtl")
	public void getRoleLocationProfileDtl(@RequestParam Long SelidRole, HttpServletResponse response) throws Exception {
		MstRole role = roleProfileService.getRoleById(SelidRole);
		JSONObject obj = MasterJSONUtil.getJsonForProfilePageRoleFlexBox(role);
		response.getWriter().print(obj);
	}
	
	@RequestMapping(value="createUpdateProfile")
	public String createUpdateProfile(@RequestParam String SelectedIDs, @RequestParam Long txtroleID,
			Long locationSelect)  {
		roleProfileService.updateRoleProfileLocation(txtroleID, locationSelect, SelectedIDs);
		return "master/roleprofile";
	}
	
	@RequestMapping("getmodules")
	public void getModules(HttpServletResponse response) throws Exception {
		List<MstModule> list = roleProfileService.getAllModules();
		JSONObject obj = MasterJSONUtil.getModuleJson(list);
		response.getWriter().print(obj);
	}
	
	@RequestMapping("getProfileModule")
	public void getProfileModule(@RequestParam Long profileId, HttpServletResponse response) throws Exception {
		List<MapModuleProfile> list = roleProfileService.getAllModulesByProfileId(profileId);
		JSONObject obj = MasterJSONUtil.getMapModuleProfile(list);
		response.getWriter().print(obj);
	}
	
	@RequestMapping("updateModuleProfile")
	public String updateModuleProfile(@RequestParam String SelectedIDs, @RequestParam Long profileSelect){
		roleProfileService.updateModuleProfile(SelectedIDs,profileSelect);
		return "master/module";
	}
	
	
		
}
	