package com.fks.pwm.controller;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fks.pwm.entity.MstEmployee;
import com.fks.pwm.service.LoginService;

@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;	
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public String login(@RequestParam String userName, @RequestParam String pwd, HttpSession session){
		logger.debug(" --- inside login --- " + userName +  pwd);
		MstEmployee emp = loginService.authenticate(userName, pwd);		
		if(emp==null){
			return "error";
		}		
		session.setAttribute("emp", emp);
		Map<String,String> moduleMap = loginService.getModules(emp);
		session.setAttribute("modules", moduleMap);
		return "welcome";
	}
	
	@ExceptionHandler(HttpSessionRequiredException.class)
	@ResponseStatus(reason="Session Expired. Please Login again.", value=HttpStatus.UNAUTHORIZED)
	public String handleExpiredSessions(){
		return "Session Expired.";
	}
	
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("showChangePass")
	public String changePassword(){
		return "master/changepass";
	}
	
	@RequestMapping("changePassword")
	public String changePassword(@RequestParam String oldPass, @RequestParam String newPass, HttpSession session, HttpServletRequest request){
		MstEmployee emp = (MstEmployee)session.getAttribute("emp");
		if(!oldPass.equals(emp.getEmpPassword())){
			request.setAttribute("msg", "Old Password Not Correct.");
			return "master/changepass";
		} else {
		loginService.changePassword(emp.getEmpId(), newPass);
		request.setAttribute("msg", "Password Changed Successfully.");
		}
		return "master/changepass";
	}
	
	@RequestMapping("forgotpassword")
	public String forgotPassword(){		
		return "master/forgotpwd";
	}
	
	@RequestMapping(value="forgotpasswordreq", method=RequestMethod.POST)
	public String forgotPasswordReq(@RequestParam String userId, HttpServletRequest request){
		String result = loginService.forgotPassword(userId);
		request.setAttribute("msg", result);
		return "login";
	}
	
}
