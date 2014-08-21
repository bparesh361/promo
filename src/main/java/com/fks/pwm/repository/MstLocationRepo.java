package com.fks.pwm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fks.pwm.entity.MstLocation;

public interface MstLocationRepo extends JpaRepository<MstLocation, Long>{

	public List<MstLocation> findByLocationName(String locationName);
	
}
