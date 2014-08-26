package com.fks.pwm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fks.pwm.entity.MstEmployee;

public interface MstEmployeeRepository extends JpaRepository<MstEmployee, Long> {

	List<MstEmployee> findByUserId(String userId);
	
	@Query("select e from MstEmployee e where e.employeeName like ?1")
	List<MstEmployee> findAllEmployeesByName(String empName);
	
	@Query("select e from MstEmployee e where e.mstRole.mstRoleId=?1")
	List<MstEmployee> findAllEmployeesByRole(Long roleId);
	
	@Query("select e from MstEmployee e where e.mstStore.mstLocation.locationId=?1")
	List<MstEmployee> findAllEmployeesByLocation(Long locationId);
	
	@Query("select e from MstEmployee e where e.mstStore.mstZone.zoneId=?1")
	List<MstEmployee> findAllEmployeesByZone(Long zoneId);
	
	@Query("select e from MstEmployee e where e.mstStore.mstStoreId=?1")
	List<MstEmployee> findAllEmployeesByStoreId(String storeId);
	
}
