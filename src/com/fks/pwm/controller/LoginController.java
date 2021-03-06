package com.fks.pwm.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.service.LoginService;

@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public String login(@RequestParam String userName, @RequestParam String pwd){
		logger.debug(" --- inside login --- " + userName +  pwd);
		MstEmployee emp = loginService.authenticate(userName, pwd);
		if(emp==null){
			return "error";
		}
		return "home";
	}
	
}
