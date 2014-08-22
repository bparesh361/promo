package com.fks.pwm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fks.pwm.entity.MstEmployee;

public interface MstEmployeeRepository extends JpaRepository<MstEmployee, String> {

	List<MstEmployee> findByUserId(String userId);
	
	@Query("select e from MstEmployee e where e.employeeName like ?1")
	public List<MstEmployee> findAllEmployeesByName(String empName);
	
	
}
