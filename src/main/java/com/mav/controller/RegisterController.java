package com.mav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mav.dao.RegisterDaoImpl;
import com.mav.entity.RegisterEntity;
import com.mav.service.MailSender;

@Controller
public class RegisterController {
	
	private RegisterDaoImpl registerdao;
	
	public RegisterController() {
	System.out.println("Default constuctor of RegisterController");
	}

	@Autowired
	public RegisterController(RegisterDaoImpl registerdao, MailSender mailsender) {
		super();
		this.registerdao = registerdao;
	}

	@RequestMapping(value = "/registerpage")
	public String goToRegisterpage() {
		return "/WEB-INF/register.jsp";
	}
	
	@RequestMapping(value = "/saveRegisterDetails")
	public String saveRegisterDetails(@RequestParam int id, @RequestParam String username, 
			@RequestParam String email, @RequestParam String password, @RequestParam String mobile,
			@RequestParam String gender, @RequestParam String birth, Model model) {
		System.out.println("Invoked into saveRegisterDetails controller ()");	
		System.out.println(id);
		System.out.println(username);
		System.out.println(email);
		System.out.println(password);
		System.out.println(mobile);
		System.out.println(gender);
		System.out.println(birth);
		
		
		RegisterEntity entity = new RegisterEntity(id, username, email, password, mobile, gender, birth);
		if(registerdao.saveRegisterDetails(entity))
		{
				System.out.println("Successfully saved");
				model.addAttribute("message", "Successfully saved the details");
				return "/WEB-INF/register.jsp";
		}
		else
		{
			model.addAttribute("message", "Something went wrong try agin...");
			return "/WEB-INF/register.jsp";
		}
			
	}
	
	
	
}
