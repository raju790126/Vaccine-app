<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<style type="text/css"> <%@include file ="/WEB-INF/CSS/login.css"%> </style>
<script type="text/javascript"><%@include file ="/WEB-INF/JS/login.js"%></script>


</head>
<body><br><br><br><br><br><br>
<div><header></header></div><br><br>
	<div class="container" id="container">
		<div class="form-container log-in-container">
			<form action="loginDetails" name="loginPage" method="post" onsubmit="return login()">
				<h1>Login</h1><br>
				
				<input type="email" placeholder="Email" name="useremail" id="email" value = "${email}" class="form-control"><span id="emailError" class="error-message" ></span>
				<input type="password" placeholder="Password"  name="password" id="pass" class="form-control"><span id="passwordError" class="error-message" ></span>
				<a href="forgotPage">Forgot your password?</a>
				<button type="submit">Log In</button>
			<h4 style="color: red;">${message}</h4>
	 		<h4 style="color: red;">${attempts}</h4>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-right">
					<h1>VACCINE APP</h1>
					<p>On successful login you can able to access your register account and features.</p>
					<p>If you don't have account, Please resiter here.</p>
					<a href="forgotPage" style="color: white">Register</a>
				</div>
			</div>
		</div>
	</div>
	<div><footer></footer></div>
</body>
</html>