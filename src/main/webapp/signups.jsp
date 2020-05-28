<%@page import="com.dao.entity.SignupEntity"%>
<%@page import="java.util.List"%>
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
  		 <h3>User Sign List</h3>
  		 <hr/>
  		 <a href="logout"><img src="img/login.png"  style="height: 60px;"></a>
  		 Current Role : - ${sessionScope.role}
  		  <br/>
  		   <hr/>
  		 Username :  ${param.username}
  		 <br/>
  		 Email :  ${email}<br/>
  		 Name :  ${name}<br/>
  		 Salutation :  ${salutation}
  		 <hr/>
  		  Total Logged in User : =  <b>${applicationScope.activeSessions-1}</b>
  		  <hr/>
  		<span style="background-color: red;font-weight: bold;"> ${param.message}</span>
  		<hr/>
  		 <table class="table table-bordered">
    <thead>
      <tr>
        <th>Username</th>
        <th>Name</th>
        <th>Email</th>
        <th>Salutation</th>
        <th>Created Date</th>
           <th>Action</th>
      </tr>
    </thead>
    <tbody>
    
    <%
    List<SignupEntity> signupList =( List<SignupEntity>)request.getAttribute("signupList");
    for(SignupEntity entity:signupList){
    %>
      <tr>
        <td><%=entity.getUsername() %></td>
        <td><%=entity.getName() %></td>
        <td><%=entity.getEmail() %></td>
          <td><%=entity.getSalutation() %></td>
            <td><%=entity.getDatecreated() %></td>
            
            <td>
            <a href="deleteSignup?sid=<%=entity.getSid() %>">
                   <img src="img/del.png"  style="height: 40px;">
            </a>
            <a href="editSignup?sid=<%=entity.getSid() %>">
                <img src="img/edit.png"  style="height: 40px;">
               </a> 
            </td>
      </tr>
     
    <% } %> 
      
    </tbody>
  </table>
  		
  </div>


</body>
</html>