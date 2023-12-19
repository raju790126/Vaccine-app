package com.mav.dao;

import com.mav.entity.RegisterEntity;

public interface ForgotInterfaceDao {
	
	public RegisterEntity getEmailDetails(String email);
	
	public boolean changePassword(RegisterEntity entity, String password);
}
