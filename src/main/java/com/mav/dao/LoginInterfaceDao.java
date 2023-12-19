package com.mav.dao;

import com.mav.entity.RegisterEntity;

public interface LoginInterfaceDao {

	public RegisterEntity getEmailDetails(String emailid); 
	
	public void updateLoginAttempts(RegisterEntity entity);
}
