package com.fks.pwm.controller;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fks.pwm.entity.MstStore;
import com.fks.pwm.service.MasterService;
import com.fks.pwm.util.MasterJSONUtil;
import com.fks.pwm.util.WebConstants;

@Controller
public class UserController {

	@Autowired
	private MasterService service;
	
	@RequestMapping("showUserPage")
	public String showUserPage(){
		return "master/user";
	}
	
	@RequestMapping("showHoStore")
	public void getOrgDetailsBySiteCode(HttpServletResponse response) throws Exception {
		MstStore store = service.getSite(WebConstants.HO_STORE_CODE);
		JSONObject object = MasterJSONUtil.getJsonForSiteSelectionUserPage(store);
		response.getWriter().print(object);	
	}
	
}
