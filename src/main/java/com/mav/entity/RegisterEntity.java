package com.mav.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "register")
public class RegisterEntity  implements java.io.Serializable{

	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "USER_NAME")
	private String username;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "MOBILE_NUMBER")
	private String mobilenumber;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "DATE_OF_BIRTH")
	private String dateofbirth;
	@Column(name = "LOGIN_ATTEMPTS")
	private int loginattempts;
	@Column(name = "MEMBER_COUNT")
	private int membercount;
	
	public RegisterEntity() {
		System.out.println("RegisterEntity obj created");
	}
	public RegisterEntity(int id, String username, String email, String password, String mobilenumber, String gender,
			String dateofbirth) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
	}

	public RegisterEntity(int id, String username, String email, String password, String mobilenumber, String gender,
			String dateofbirth, int loginattempts, int membercount) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.loginattempts = loginattempts;
		this.membercount = membercount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	public int getLoginattempts() {
		return loginattempts;
	}

	public void setLoginattempts(int loginattempts) {
		this.loginattempts = loginattempts;
	}
	
	public int getMembercount() {
		return membercount;
	}

	public void setMembercount(int membercount) {
		this.membercount = membercount;
	}

	@Override
	public String toString() {
		return "RegisterEntity [" + id + ", " + username + ", " + email + ", " + password
				+ ", " + mobilenumber + ", " + gender + ", " + dateofbirth+", "+ loginattempts + "]";
	}
	
	
}
