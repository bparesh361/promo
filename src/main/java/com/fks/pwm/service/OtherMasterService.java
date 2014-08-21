package com.fks.pwm.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fks.pwm.entity.MstCalender;
import com.fks.pwm.entity.MstCampaign;
import com.fks.pwm.repository.CalendarRepo;
import com.fks.pwm.repository.CampaignRepo;

@Service
@Transactional(readOnly=true)
public class OtherMasterService {

	@Autowired
	private CampaignRepo campaignRepo;
	
	@Autowired
	private CalendarRepo calendarRepo;
	
	public List<MstCampaign> getAllCampaign(){
		return campaignRepo.findAll();
	}
	
	public List<MstCalender> getAllCalendar(){
		return calendarRepo.findAll();
	}
	
	@Transactional(readOnly=false)
	public boolean udpateCampaign(MstCampaign campaign){
		if(campaign==null){
			return false;
		}
		if(campaign.getCampaignId()==null){
			campaignRepo.save(campaign);			
		} else {
			MstCampaign dbCampaign = campaignRepo.findOne(campaign.getCampaignId());
			dbCampaign.setCampaignName(campaign.getCampaignName());
			dbCampaign.setIsActive(campaign.getIsActive());
		}
		return true;
	}
	
	@Transactional(readOnly=false)
	public boolean udpateCalendar(MstCalender calender){
		if(calender==null){
			return false;
		}
		if(calender.getMstCalenderId()==null){
			calendarRepo.save(calender);			
		} else {
			MstCalender dbCalendar = calendarRepo.findOne(calender.getMstCalenderId());
			dbCalendar.setCalDate(calender.getCalDate());
			dbCalendar.setDateDescription(calender.getDateDescription());
		}
		return true;
	}
	
	public List<MstCalender> getAllCalendarsByMonthAndYear(String month,String year){
		return calendarRepo.getCalendarsByMonthAndYear(month, year);
	}
	
	public List<MstCalender> getAllCalendarsByYear(String year){
		return calendarRepo.getCalendarsByYear(year);
	}
	
}
