<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
   <html lang="en">
   <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Landing Page</title>
    <link rel="stylesheet" href="style.css">

<style type="text/css">
body {
    font-family: Arial, sans-serif;
    font-size: 16px;

    background-image: url("/WEB-INF/img/vaccine.jpg");
}

header {
    background-color: #171313;
    padding: 10px;
}

header h1 {
    margin: 0;
}

nav a {
    margin-right: 10px;
    text-decoration: none;
    color: #333;
}

#content {
    padding: 20px;
}

.grid {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    grid-gap: 20px;
}

.grid img {
    width: 100%;
    height: auto;
}

footer {
    margin-top: 500px;
    background-color: #171313;
    padding: 5px;
    text-align: center;
}
ul{
 display: inline-flex;
  list-style: none;
  margin-left: 1000px;
}
ul li:first-child{
  margin-left: 0px;
}
 ul li a{
  text-decoration: none;
  color: #fff;
  font-size: 12px;
  font-weight: 500;
  padding: 8px 15px;
  border-radius: 5px;
  transition: all 0.3s ease;
}
 ul li a:hover{
  background: #fff;
  color: black;
}
.center{
  position: absolute;
  top: 52%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 97%;
  padding: 0 20px;
  text-align: center;
}
 section{
 background-color: #C1D8CE;
 }

</style>
   </head>
   <body>
      <header>
        <nav>
        <ul>
        
        <li><a href="registerpage">Register</a></li>
        <li><a href="loginpage">Login</a></li>
      </ul>
        </nav>
    </header>

    <section id="content">
        <div class="center">
  			<h1 >welcome to vaccine App</h1>
  	
  		</div>
    </section>

    <footer>
        <p>&copy; 2021 My Website. All rights reserved.</p>
    </footer>
</body>

</html>