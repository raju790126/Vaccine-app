<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Form</title>
<style><%@include file="/WEB-INF/CSS/addmember.css"%></style>
<script><%@include file="/WEB-INF/JS/addmember.js"%></script>




</head>
<body>
	<header>
	<ul>
        <li><a href="backToHome">Back</a></li>
    </ul>
	</header>
	<div class="container">
	 <form id="form" action="saveTheMember"  name="addMemberForm" method="post" onsubmit="return validateForm()">
	 <h1>Add Member</h1>
	 
	 <div class="input-group">
	 <label for="name">Member Name</label>
	 <input type="text" id="name" required name ="memname">
	 <span id="idError" class="error-message"></span>
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
	 
	  <div class="input-group">
	 <label for="mobile">ID-Proof </label>
	  <select name="idProof" required="required">
		<option value="">select</option>
		<option value="Aadhar Card">Aadhar Card</option>
		<option value="Pan Card">Pan Card</option>
		<option value="PassPort">PassPort</option>
	 </select>	
	 <div class="error"></div>
	 </div>
	 
	 <div class="input-group">
	 <label for="proof">Proof-ID-No</label>
	 <input type="text" id="proof" required name ="proofno">
	 <span id="idError" class="error-message"></span>
	 </div>
	 
	 <div class="input-group">
	 <label for="mobile">Vaccine-Type</label>
	  <select name="vaccType" required="required">
		<option value="">select</option>
		<option value="CoviShield">CoviShield</option>
		<option value="Co-Vaccine">Co-Vaccine</option>
	 </select>	
	 <div class="error"></div>
	 </div>
	 
	 <div class="input-group">
	 <label for="mobile">No-Of-Dose</label>
	  <select name="dose" required="required">
		<option value="">select</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
	 </select>	
	 <div class="error"></div>
	 </div>
	 
	 <button type="submit">ADD</button>
	 <h2 style="color: red;"><center>${message}</center></h2>
	 </form>
 </div>
 <footer></footer>
</body>
</html>