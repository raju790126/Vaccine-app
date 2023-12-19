<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-type" content="text/html; charset = ISO-8859-1">
<title>Home page</title>
<style type="text/css"><%@include file = "/WEB-INF/CSS/homepage.css" %></style>
</head>
<body>
	<% response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	
	
	%>

	 <nav>
    <div class="menu">
    <ul>
	    <li><a href="addmembers">addMembers</a></li>
	    <li><a href="viewmembers">viewMembers</a></li>
    </ul>
      <div class="logo">
        <center> <a href="#">Vaccine App</a></center>
      </div>
      <ul>
        <li><a href="#">${ email}</a></li>
        <li><a href="logout">Logout</a></li>
      </ul>
    </div>
  </nav>
  <div class="img"></div>
  <div class="center">

<div class="row">
  <div class="column">
    <div class="card">
      <img src="img_avatar2.png" alt="Avatar" style="width:100%">
  <div class="container">
    <h4><b>${count}</b></h4> 
    <p>Total No of Members</p> 
  </div>
    </div>
  </div>

  <div class="column">
    <div class="card">
      <img src="img_avatar2.png" alt="Avatar" style="width:100%">
  <div class="container">
    <h4><b>Member 1</b></h4> 
    <p>Interior Designer</p> 
  </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
     <img src="img_avatar2.png" alt="Avatar" style="width:100%">
  <div class="container">
    <h4><b>Member 2</b></h4> 
    <p>Interior Designer</p> 
  </div>
    </div>
  </div>
  
  <div class="column">
    <div class="card">
      <img src="img_avatar2.png" alt="Avatar" style="width:100%">
  <div class="container">
    <h4><b>Member 3</b></h4> 
    <p>Interior Designer</p> 
  </div>
    </div>
  </div>
</div>
  	
  	
  	
    <h2 style="color: red;"><center>${message}</center></h2>
  </div>
</body>
</html>