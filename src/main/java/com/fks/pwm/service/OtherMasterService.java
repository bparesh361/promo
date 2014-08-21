package com.fks.pwm.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fks.pwm.entity.MstCampaign;
import com.fks.pwm.repository.CampaignRepo;

@Service
@Transactional(readOnly=true)
public class OtherMasterService {

	@Autowired
	private CampaignRepo campaignRepo;
	
	public List<MstCampaign> getAllCampaign(){
		return campaignRepo.findAll();
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
	
}
