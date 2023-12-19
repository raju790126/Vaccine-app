package com.mav.service;

import org.springframework.stereotype.Component;

@Component
public class LoginServicesImpl implements LoginInterface {

	@Override
	public boolean validateLoginDetails(String email, String Password) {

		System.out.println("Invoked into validateLoginDetails()");
		if(!(email != null && !email.isEmpty() && !email.isBlank()))
		{
			return false;
		}
		if(!(Password != null && !Password.isEmpty() && !Password.isBlank()))
		{
			return false;
		}
		
		return true;
	}

}
