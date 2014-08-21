package com.fks.pwm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fks.pwm.entity.MstEmployee;

public interface MstEmployeeRepository extends JpaRepository<MstEmployee, String> {

	public List<MstEmployee> findByUserId(String userId);
	
}
