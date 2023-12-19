<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
  margin: 0
}
header{
	 background-color: #171313;
	 border-radius: 10px;
    padding: 26px;
    width: 95%;
}
footer{
	background-color: #171313;
	 border-radius: 10px;
    padding: 30px;
    margin-top: 120px;
    width: 95%;
}
header a {
    margin-right: 10px;
    text-decoration: none;
    color: #333;
}
li a{
  text-decoration: none;
  color: #fff;
  font-size: 12px;
  font-weight: 500;
  padding: 8px 15px;
  border-radius: 5px;
  transition: all 0.3s ease;
}
li a:hover{
  background: #fff;
  color: black;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  height: 100vh;
  background-color:  #78D6CE;
}

.container h1 {
  color: 0F0F0E;
  font-family: sans-serif;
  margin: 20px;
}

.registartion-form {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 600px;
  color: #070808;
  font-size: 18px;
  font-family: sans-serif;
  background-color: #C5ECE9;
  padding: 15px;
  border-radius: 10px;
}

.registartion-form input,
.registartion-form select,
.registartion-form textarea {
  border: none;
  padding: 5px;
  margin-top: 10px;
  font-family: sans-serif;
   border-radius: 7px;
}

.registartion-form input:focus,
.registartion-form textarea:focus {
  box-shadow: #EA0012;
}

.registartion-form .submit {
  width: 60%;
  padding: 8px 0;
  margin-left:70px;
  font-size: 20px;
  color: #F4F4F4;
  background-color: #3631CA;
  border-radius: 5px;
}

.registartion-form .submit:hover {
  box-shadow: 3px 3px 6px rgb(255, 214, 176);
}
</style>
</head>
<body>

	<div class="container">
	<header> <li><a href="backToViewmembers">Back</a></li></header>
  <h1>Update Member Details</h1>
  <div><form name="registration" action="${pageContext.request.contextPath }/updateMember" class="registartion-form">
    <table>
      <tr>
        <td><label for="name">Member Name:</label></td>
        <td><input type="text" name="name" id="name" value="${name}"></td>
      </tr>
      <tr>
        <td><label for="idoof">Gender:</label></td>
        <td>
          <select name="gender" id="idoof">
            <option value="${gender}" selected>${gender}</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Others">Others</option>
          </select>
        </td>
      </tr>
      <tr>
        <td><label for="birth">DOB:</label></td>
        <td><input type="date" name="birth" id="birth" value="${birth}"></td>
      </tr>
      
      <tr>
        <td><label for="idproof">ID Proof:</label></td>
        <td>
          <select name="idproof" id="idproof">
            <option value="${idproof}"selected>${idproof}</option>
            <option value="AadharCard">AadharCard</option>
            <option value="PanCard">PanCard</option>
            <option value="PassPort">PassPort</option>
          </select>
        </td>
      </tr>
      <tr>
        <td><label for="proofno">Proof-ID-No:</label></td>
        <td><input type="text" name="proofno" id="proofno" value="${proofno}"></td>
      </tr>
      <tr>
        <td><label for="if">Vaccine-Type</label></td>
        <td>
          <select name="vacctype" id="if">
            <option value="${vaccinetype}"selected>${vaccinetype}</option>
            <option value="CoviShield">CoviShield</option>
            <option value="Co-Vaccine">Co-Vaccine</option>
          </select>
        </td>
      </tr>
      <tr>
        <td><label for="dose">Dose:</label></td>
        <td>
          <select name="dose" id="dose" type="number">
            <option value="${dose}" selected>${dose}</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
          </select>
        </td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" class="submit" value="Update" /></td>
      </tr>
    </table>
  </form></div>
  <footer></footer>
</div>

</body>
</html>