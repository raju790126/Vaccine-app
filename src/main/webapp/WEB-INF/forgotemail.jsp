<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Yinka Enoch Adedokun">
	<meta name="description" content="Simple Forgot Password Page Using HTML and CSS">
	<meta name="keywords" content="forgot password page, basic html and css">
	<title>Forgot Password Page</title>
	<style type="text/css"><%@include file="/WEB-INF/CSS/forgotemail.css"%></style>
	<script type="text/javascript"><%@include file="/WEB-INF/JS/forgotemail.js"%></script>
	
</head>
<body>
	<div class="row">
		<h1>Forgot Password</h1>
		<h6 class="information-text" style="color: black;">Enter your registered email to reset your password.</h6>
		
		<form action="forgotegmail" name="forgotForm" method="post" onsubmit="return validateForm()">
		<div class="form-group">
			<input type="email" name="useremail" id="user_email">
			<p><label for="username">Email</label></p>
			<p><span id="emailError" class="error-message"></span></p>
			
			<input type="password" name="newpassword" id="newpass">
			<p><label for="newpass">New Password</label></p>
			<p><span id="passwordError" class="error-message"></span></p>
			
			<input type="password" name="confirmpassword" id="connewpass">
			<p><label for="connewpass">Confirm Password</label></p>
			<p><span id="confirmPasswordError" class="error-message"></span></p>
			
			<button type="submit">Reset Password</button>
		</div>
		</form>
		<div class="footer">
			<h5 style="color: red;"><center>${ message}</center> </h5>
			<h5>New here? <a href="#">Sign Up.</a></h5>
			<h5>Already have an account? <a href="#">Sign In.</a></h5>
		</div>
	</div>
</body>
</html>