package com.fks.pwm.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private SimpleMailMessage forgetPwdMsg;
	
	public void sendForgotPasswordMsg(String toEmail, String password,BigInteger userName){
		forgetPwdMsg.setTo(toEmail);
		forgetPwdMsg.setText("Dear "+userName+", \n\nYour Password has been recovered succesfully. \n\nPassword is : " + password + "\n\n\nThanks. \nAdmin Promotion-Workflow  ");
        mailSender.send(forgetPwdMsg);
	}
	
}
