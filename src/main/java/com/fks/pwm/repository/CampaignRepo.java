package com.fks.pwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fks.pwm.entity.MstCampaign;

public interface CampaignRepo extends JpaRepository<MstCampaign, Long>{

}
