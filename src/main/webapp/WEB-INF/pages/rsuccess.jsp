<!DOCTYPE html>
<html>
<head>
<title>Success</title>
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
        Total Logged in User : =  ${applicationScope.activeSessions}
  		<img src="img/congrates.png"  style="height: 120px;">
  		 <h1>You are registered successfully!!!!!!!!!!!!</h1>
  		 <hr/>
  		  <a href="login.jsp">
  		     <button type="button" class="btn btn-danger">Click to sign in</button>
  		     </a>
  	</div>	
</body>
</html>