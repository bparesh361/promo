package com.fks.pwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fks.pwm.entity.MstProfile;

public interface ProfileRepo extends JpaRepository<MstProfile, Long>{

}
