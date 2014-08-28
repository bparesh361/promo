package com.fks.pwm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fks.pwm.entity.MstRole;

public interface RoleRepo extends JpaRepository<MstRole, Long>{

	@Query("select r from MstRole r where r.roleName like ?1")
	List<MstRole> findAllRolesByName(String rolename);

	
}
