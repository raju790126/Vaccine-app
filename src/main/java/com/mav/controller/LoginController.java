package com.mav.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mav.dao.LoginDaoImpl;
import com.mav.entity.RegisterEntity;
import com.mav.service.LoginServicesImpl;
import com.mav.service.MailSender;

@Controller
public class LoginController {
	
	private static RegisterEntity entity=null;
	private LoginServicesImpl loginServices;
	private LoginDaoImpl loginDao;
	private MailSender mailsender;
	public LoginController() {
		System.out.println("Default constuctor of RegisterController");
	}
	
	@Autowired
	public LoginController(LoginServicesImpl loginServices, LoginDaoImpl loginDao, MailSender mailsender) {
		super();
		this.loginServices = loginServices;
		this.loginDao = loginDao;
		this.mailsender = mailsender;
	}

	@RequestMapping(value = "/loginpage")
	public String goToLoginpage() {
		return "/WEB-INF/login.jsp";
	}
	
	@RequestMapping(value = "/loginDetails")
	public String loginDetails(@RequestParam String useremail, @RequestParam String password, Model model, HttpServletRequest req) {
		System.out.println("Invoked into loginDetails()");
		
		if(loginServices.validateLoginDetails(useremail, password)) {
			entity = loginDao.getEmailDetails(useremail);
			if(entity != null ) {
				if (entity.getLoginattempts() < 2)
				{
					if( entity.getPassword().equals(password)) {
						HttpSession session = req.getSession();
						session.setAttribute("email", useremail);
						session.setAttribute("Mainentity", entity);
						model.addAttribute("email", entity.getEmail());
						model.addAttribute("count", entity.getMembercount());
						return "/WEB-INF/homepage.jsp";
					}
					else{
						loginDao.updateLoginAttempts(entity);
						System.out.println(entity);
						model.addAttribute("email", useremail);
						model.addAttribute("message", "Password Doesn't Match Try agin.....");
						model.addAttribute("attempts", "your remaing attempts 2 out of : "+entity.getLoginattempts());
						return "/WEB-INF/login.jsp";
					}
				} 
				else {
					mailsender.sendMail(useremail);
					model.addAttribute("message", "Your trying attempts over, your account is blocked");
					return "/WEB-INF/login.jsp";
				}
			}
			else {
				model.addAttribute("message", "The useremail doesn't exits");
				return "/WEB-INF/login.jsp";
			}
		}
		else{
			model.addAttribute("message", "The user deatils is not valid Try again..");
			return "/WEB-INF/login.jsp";
		}
	}
}
