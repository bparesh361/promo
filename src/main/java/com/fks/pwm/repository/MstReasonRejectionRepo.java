package com.fks.pwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.fks.pwm.entity.MstReasonRejection;

public interface MstReasonRejectionRepo extends JpaRepository<MstReasonRejection, Long> {

	@Query("select r from MstReasonRejection r where r.isApprover=?1")
	public List<MstReasonRejection> getRejectionByApprover(Byte isApprover);
	
}
