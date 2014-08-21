package com.fks.pwm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fks.pwm.entity.MstCampaign;
import com.fks.pwm.service.OtherMasterService;
import com.fks.pwm.util.OtherMasterJSONUtil;

@Controller
public class OtherMasterController {

	@Autowired
	private OtherMasterService service;
	
	@RequestMapping("showCampaignPage")
	public String showCampaignPage(){
		return "master/other/campaign";
	}
	
	@RequestMapping("showCampaignData")
	public void showCampaignData(HttpServletResponse response) throws Exception {
		List<MstCampaign> list = service.getAllCampaign();
		JSONObject obj = OtherMasterJSONUtil.getJsonForLeadTimeStatus(list);
		response.getWriter().print(obj);		
	}
	
	@RequestMapping("updateCampaign")
	public String updateCampaign(@ModelAttribute MstCampaign campaign, HttpServletRequest request){
		boolean result = service.udpateCampaign(campaign);
		if(result) {
			request.setAttribute("msg", "Campaign created / updated successfully with Id " + campaign.getCampaignId());
		} else {
			request.setAttribute("msg", "Error !!!");
		}
		return "master/other/campaign";
	}
	
}
