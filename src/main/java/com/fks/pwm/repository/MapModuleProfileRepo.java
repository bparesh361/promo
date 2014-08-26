package com.fks.pwm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fks.pwm.entity.MapModuleProfile;

public interface MapModuleProfileRepo extends JpaRepository<MapModuleProfile, Long>{

	@Query(value="select mpr from MapModuleProfile mpr where mpr.mstProfile.profileId=?1")
	List<MapModuleProfile> getAllModuleProfileByProfileId(Long profileId);
	
}
