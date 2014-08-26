package com.fks.pwm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.entity.MstStore;

public interface StoreRepo extends JpaRepository<MstStore, String>{

	@Query("select s from MstStore s where s.mstLocation.locationId=?1")
	public List<MstStore> getAllStoresByLocationId(Long locationId);
	
	@Query("select s from MstStore s where s.siteDescription like ?1")
	List<MstStore> findAllStoresByName(String siteDesc);

	
}
