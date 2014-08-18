package com.fks.pwm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.repository.MstEmployeeRepository;

@Service
@Transactional
public class LoginService {


	@Autowired
	private MstEmployeeRepository empRepo;
	
	public MstEmployee authenticate(String userName, String pwd){
		List<MstEmployee> list = empRepo.findByUserId(userName);
		for(MstEmployee emp : list){
			if(emp.getEmpPassword().equals(pwd)) {
				return emp;
			}
		}
		return null;
	}
	
}
