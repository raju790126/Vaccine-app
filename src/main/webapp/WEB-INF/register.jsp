<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Form</title>
<style><%@include file="/WEB-INF/CSS/register.css"%></style>
<script><%@include file="/WEB-INF/JS/register.js"%></script>




</head>
<body>
	<header></header>
	<div class="container">
	 <form id="form" action="saveRegisterDetails"  name="registrationForm" method="post" onsubmit="return validateForm()">
	 <h1>Register</h1>
	 
	 <div class="input-group">
	 <label for="id">ID</label>
	 <input type="number" id="id" required name ="id">
	 <span id="idError" class="error-message"></span>
	 </div>
	 
	 <div class="input-group">
	 <label for="username">User Name</label>
	 <input type="text" required name ="username" id="username">
	 <div class="error"><span id="nameError" class="error-message"></span></div>
	 </div>
	 
	 <div class="input-group">
	 <label for="email">Email</label>
	 <input type="email" id="email" required name="email" >
	 <div class="error"><span id="emailError" class="error-message"></span></div>
	 </div>
	 
	 <div class="input-group">
	 <label for="password">Password</label>
	 <input type="password" id="password" required name="password">
	 <div class="error"><span id="passwordError" class="error-message"></span></div>
	 </div>
	 
	 <div class="input-group">
	 <label for="cpassword">Confirm Password</label>
	 <input type="password" id="cpassword" required  name="confirmPassword">
	 <div class="error"><span id="confirmPasswordError" class="error-message"></span></div>
	 </div>
	 
	 <div class="input-group">
	 <label for="mobile">Mobile Number </label>
	 <input type="text" id="mobile" required  name="mobile">
	 <div class="error"><span id="mobileError" class="error-message"></span></div>
	 </div>
	 
	 <div class="input-group">
	 <label for="gender">Gender</label>
	 <select name="gender" required="required">
		<option value="">select</option>
		<option value="Male">Male</option>
		<option value="Female">Female</option>
	 </select>	
	 <div class="error"></div>
	 </div>
	 
	 <div class="input-group">
	 <label for="birth">Date Of Birth</label>
	 <input type="date" id="birth" required  name ="birth">
	 <div class="error"></div>
	 </div>
	 
	 <button type="submit">Register</button>
	 <h2 style="color: red;"><center>${message}</center></h2>
	 </form>
 </div>
 <footer></footer>
</body>
</html>