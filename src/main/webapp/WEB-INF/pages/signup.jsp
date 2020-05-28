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
  <header style="height: 30px;background-color: #2196f3;">
  </header>
  
  <div  class="container">
        <br/>
  		<img src="img/signup-2.png"  style="height: 160px;">
  		 <h3>User Sign Up</h3>
  		 <hr/>
  		 
  		 <form action="signup"  method="post">
  		  Username<b>*</b>
  		   <input type="text"  name="username"  class="form-control"  style="width: 50%;">
  		   
  		   Password<b>*</b>
  		   <input type="password"  name="password"  class="form-control"  style="width: 50%;">
  		    
  		    Name<b>*</b>
  		   <input type="text"  name="name"  class="form-control"  style="width: 50%;">
  		   
  		   
  		    Email<b>*</b>
  		   <input type="text"  name="email"  class="form-control"  style="width: 50%;">
  		   
  		      Salutation
  		   <select  name="salutation"  class="form-control"  style="width: 50%;">
  		        <option>Mr</option>
  		        <option>Miss</option>
  		   </select>
  		   
  		   
  		   
  		    <br/>
  		   <button type="submit" class="btn btn-primary">Sign Up</button>
  		   
  		     <a href="login.jsp">
  		     <button type="button" class="btn btn-danger">Sign In</button>
  		     </a>
  		   </form>
  </div>


</body>
</html>