package com.mav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailSender {
	
	private JavaMailSenderImpl mailSender;

	@Autowired
	public MailSender(JavaMailSenderImpl mailSender) {
		super();
		this.mailSender = mailSender;
	}
	
	public boolean sendMail(String email)
	{
		String subject = "Account Blocked";
		String body = "Your account is blocked, Due to tried too many attempts."
				+ "Please reset your password & login again.";
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		try {
			mailSender.send(mailMessage);
			System.out.println("Mail was sent succesfully");
			return true;
		} catch (MailException e) {
			System.out.println("The exception is :"+e.getMessage());
			return false;
		}
		
	}
	
	
	public boolean sendOTP(String email) {
		String subject = "One Time Password";
		String body = "Your account is blocked, Due to tried too many attempts."
				+ "so reset your password for that OTP : 262626";
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		try {
			mailSender.send(mailMessage);
			System.out.println("Mail was sent succesfully");
			return true;
		} catch (MailException e) {
			System.out.println("The exception is :"+e.getMessage());
			return false;
		}
	}
	
	
}
