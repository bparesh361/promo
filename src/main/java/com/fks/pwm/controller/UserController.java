package com.fks.pwm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.entity.MstRole;
import com.fks.pwm.entity.MstStore;
import com.fks.pwm.service.MasterService;
import com.fks.pwm.util.CommonUtil;
import com.fks.pwm.util.MasterJSONUtil;
import com.fks.pwm.util.WebConstants;
import com.fks.pwm.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	private MasterService service;
	
	@RequestMapping("showUserPage")
	public String showUserPage(){
		return "master/user";
	}
	
	@RequestMapping("showStores")
	public void getOrgDetailsBySiteCode(@RequestParam Long storeType, HttpServletResponse response) throws Exception {
		List<MstStore> stores;
		if(storeType==1){
			stores = service.getSites(WebConstants.HO);
		} else if(storeType==2){
			stores = service.getSites(WebConstants.STORE);
		} else {
			stores = service.getSites(WebConstants.ZONE);
		}
		JSONObject object = MasterJSONUtil.getJsonForSiteSelectionUserPage(stores);
		response.getWriter().print(object);	
	}
	
	@RequestMapping("showRoles")
	public void showRoles(HttpServletResponse response) throws Exception {
		List<MstRole> list = service.findAllRoles();
		JSONObject object = MasterJSONUtil.getJsonForRoles(list);
		response.getWriter().print(object);	
		
	}
	
	@RequestMapping("storeDesc")
	public void getStoreDesc(@RequestParam String storeCode, HttpServletResponse repsonse) throws Exception {
		MstStore store = service.getStore(storeCode);
		repsonse.getWriter().print(MasterJSONUtil.getJsonForSiteDescription(store));
	}
	
	@RequestMapping("createuser")
	public String createUser(@ModelAttribute UserVO vo,HttpServletRequest request) {
		MstRole role = service.getRole(vo.getRole());
		MstStore store = getStore(vo);
		MstEmployee emp = CommonUtil.getEmployeeFromVO(vo, role, store);
		service.createEmployee(emp);
		request.setAttribute("msg", "User Created / Updated Successfully.");
		return "master/user";
	}	
	
	private MstStore getStore(UserVO vo){
		String storeCode;
		if(vo.getSiteType().equals("zone")){
			storeCode = vo.getZoneSelect();
		} else if(vo.getSiteType().equals("store")){
			storeCode = vo.getStoreSelect();
		}
		else { 
			storeCode = vo.getHoSelect();
		}
		return service.getStore(storeCode);	
	}
	
	@RequestMapping("getEmployeeForFlexBox")
	public void getEmployee(@RequestParam String txtuserempName, HttpServletResponse repsonse) throws Exception {
		List<MstEmployee> list = service.searchEmployeeByName(txtuserempName);
		repsonse.getWriter().print(MasterJSONUtil.getJsonForEmployeeFlexBox(list));
	}
	
}
