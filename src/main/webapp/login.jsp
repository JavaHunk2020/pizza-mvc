<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
  <header style="height: 30px;background-color: #2196f3;color:white;">
      Email - >>>   <b>${applicationScope.adminEmail}</b>     ->>>   Email - >>>  <b> ${applicationScope.adminMobile}</b>    
  </header>
  
  <div  class="container">
        <br/>
  		<img src="img/signup.png"  style="height: 120px;">
  		 <hr/>
  		 
  		 <form action="auth"  method="post">
  		  <b>Username</b>
  		   <input type="text"  name="username"  class="form-control"  style="width: 50%;">
  		   
  		   <b>Password</b>
  		   <input type="password"  name="password"  class="form-control"  style="width: 50%;">
  		    <br/>
  		   <button type="submit" class="btn btn-primary">Sign In</button>
  		   
  		     <a href="signup.jsp">
  		     <button type="button" class="btn btn-danger">Sign Up</button>
  		     </a>
  		     
  		   
  		   </form>
  </div>


</body>
</html>