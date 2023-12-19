package com.mav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mav.dao.ForgotDaoImpl;
import com.mav.entity.RegisterEntity;

@Controller
public class ForgotPasswordController {

	private ForgotDaoImpl forgotdao;
	
	public ForgotPasswordController() {
		System.out.println("Invoked into ForgotPasswordController() default controller");
	}

	@Autowired
	public ForgotPasswordController(ForgotDaoImpl forgotdao) {
		this.forgotdao = forgotdao;
	}

	@RequestMapping(value = "/forgotPage")
	public String forgetPage() {
		return "/WEB-INF/forgotemail.jsp";
	}
	
	@RequestMapping(value = "/forgotegmail")
	public String forgotEmail(@RequestParam String useremail,@RequestParam String newpassword,
							 Model model) {
		System.out.println("Invoked into forgotEmail()");
		RegisterEntity entity = forgotdao.getEmailDetails(useremail);
		if(entity != null)
		{
			if(forgotdao.changePassword(entity, newpassword)) {
				return "/WEB-INF/login.jsp";
			}
			else{
				model.addAttribute("message", "Some thing went wrong Try again..!");
				return "/WEB-INF/forgotemail.jsp";
			}
		}
		else{
			model.addAttribute("message", "Email ID doesn't exits Try again..!");
			return "/WEB-INF/forgotemail.jsp";			
		}
		
		
	}
	
	
}
