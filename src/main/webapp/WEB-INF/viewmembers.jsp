<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.mav.controller.AddMembersController" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view members</title>
<style type="text/css">
	<%@include file= "/WEB-INF/CSS/viewmembes.css" %>
</style>
</head>
<body>
<div>
<header>
	<a href="backToHome2">Back</a>
	</header></div>
<div class="container">
  <h2><b>Added Members</b></h2>
  <h1><center>${message} </center></h1>
  <ul class="responsive-table">
    <li class="table-header">
      <div class="col col-1"><b>ID</b></div>
      <div class="col col-2"><b>EMAIL</b></div>
      <div class="col col-3"><b>NAME</b></div>
      <div class="col col-4"><b>GENDER</b></div>
      <div class="col col-5"><b>DOB</b></div>
      <div class="col col-6"><b>ID PROOF</b></div>
      <div class="col col-7"><b>PROOF NO</b></div>
      <div class="col col-8"><b>VACCINE</b></div>
      <div class="col col-9"><b>DOSE</b></div>
      <div class="col col-10"><b>EDIT</b></div>
      <div class="col col-11"><b>DELETE</b></div>
    </li>
	<c:forEach var="member" items="${list}">
	 <li class="table-row">
      <div class="col col-1" data-label="MEMBER ID">${member.getId()}</div>
      <div class="col col-2" data-label="EMAIL">${member.getUseremail() }</div>
      <div class="col col-3" data-label="MEMBER NAME">${member.getMemberName() }</div>
      <div class="col col-4" data-label="GENDER">${member.getGender() }</div>
      <div class="col col-5" data-label="DATE OF BIRTH">${member.getBirth() }</div>
      <div class="col col-6" data-label="ID PROOF">${member.getIdProof() }</div>
      <div class="col col-7" data-label="PROOF NO">${member.getProofNo() }</div>
      <div class="col col-8" data-label="VACCINE TYPE">${member.getVaccineType() }</div>
      <div class="col col-9" data-label="DOSE">${member.getDose() }</div>
      <div class="col col-10" data-label="EDIT"><a href="editMemberDetails/${ member.getId()}">Edit</a></div>
      <div class="col col-11" data-label="DELETE"><a href="deleteMember/${ member.getId()}">Delete</a></div>
    </li>
	
	</c:forEach>
    
  </ul>
  <h2>${message1}</h2>
</div>
<footer></footer>
</body>
</html>