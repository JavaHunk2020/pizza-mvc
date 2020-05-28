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
      Hello ${sessionScope.salutation}                              =                          Email :  ${sessionScope.email}
  </header>
  
  <div  class="container">
        <br/>
  		<img src="img/congrates.png"  style="height: 120px;">
  		 <h1>You are a valid user and your details are</h1>
  		   Total Logged in User : =  ${applicationScope.activeSessions}
  		 <hr/>
  		 Username :  ${param.username}
  		 <br/>
  		 Email :  ${email}<br/>
  		 Name :  ${name}<br/>
  		 Salutation :  ${salutation}
  		 <hr/>
  		     <a href="users">
  		     <button type="button" class="btn btn-danger">Users</button>
  		     </a>
  	</div>	
</body>
</html>