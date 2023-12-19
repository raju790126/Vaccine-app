package com.mav.service;

public interface ForgogtPasswordService {
	
	boolean validateUserData(String email, String newpassword, String ConfirmPassword);
	
	boolean resetPasswordByEmail(String email, String newpassword);
	
	// 1 = Create forgot jsp file which consist of email, New password, Confirm Password.
	// 2 = Create method in service for boolean validateUserData(String email, String newpassword, String ConfirmPassword);
	// 3 = Create method in DAO for boolean resetPasswordByEmail(String email, String newpassword);
	// 4 = Write a hql query to get the Register entity by email in dao.
	// 5 = Reset the value login attempts from 3 to 0.
	// 6 = Replace the old password with new password.
	// 7 = Send an email to register user by attaching new password.

}
