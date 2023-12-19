package com.mav.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LogoutController {

	@GetMapping(value = "/logout")
	public String logoutAccount( HttpServletRequest r)
	{
		HttpSession session = r.getSession(false);
		if(session != null)
		{
			session.invalidate();
		}
		return "redirect:/loginpage";
		
	}
}
