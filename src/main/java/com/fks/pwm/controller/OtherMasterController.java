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

import com.fks.pwm.entity.MstCalender;
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
	
	@RequestMapping("showCalendarPage")
	public String showCalendarPage(){
		return "master/other/calendar";
	}
	
	@RequestMapping("showCalendarData")
	public void showCalendarData(HttpServletResponse response) throws Exception {
		List<MstCalender> list = service.getAllCalendar();
		JSONObject obj = OtherMasterJSONUtil.getJsonForCalendar(list);
		response.getWriter().print(obj);
		response.getWriter().flush();
	}
	
	@RequestMapping("getAllCalendarByYearAndMonth")
	public void getAllCalendarByYearAndMonth(@RequestParam(required=false) String year, @RequestParam(required=false) String month, HttpServletResponse response) throws Exception{
		List<MstCalender> list=null;
		if(month!=null){
			list = service.getAllCalendarsByMonthAndYear(month, year);			
		} else {
			list = service.getAllCalendarsByYear(year);
		}
		JSONObject obj = OtherMasterJSONUtil.getJsonForCalendar(list);
		response.getWriter().print(obj);
	}
	
	@RequestMapping("updateCampaign")
	public String updateCalendar(@ModelAttribute MstCalender calender, HttpServletRequest request){
		boolean result = service.udpateCalendar(calender);
		if(result) {
			request.setAttribute("msg", "Calendar created / updated successfully with Id " + calender.getMstCalenderId());
		} else {
			request.setAttribute("msg", "Error !!!");
		}
		return "master/other/calendar";
	}
	
	
		
}
