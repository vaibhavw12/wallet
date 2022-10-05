<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Signup" method="post">
<div>
      <table style="margin-left:auto; margin-right:auto; padding-top:150px">
      <tr> 
      <th><label for="text"><b>Name</b></label></th>
      <th><input type="text" placeholder="Enter Full Name" name="name" required></th>
      </tr>
      <tr> 
      <th><label for="number"><b>Phone</b></label></th>
      <th><input type="number" placeholder="Enter Phone Number" name="phone" required></th>
      </tr>
      <tr> 
      <th><label for="email"><b>Email</b></label></th>
      <th><input type="email" placeholder="Enter Email" name="email" required></th>
      </tr>
	  <tr> 
     <th> <label for="password"><b>Password</b></label></th>
     <th><input type="password" placeholder="Enter Password" name="password" required></th>
      </tr>
      </table>
      <div style=text-align:center;padding-top:5px>
      <a href="index.html"><button type="button">Cancel</button></a>
        <button type="submit">Signup</button>
        </div>
      </div>
       </form>
</body>
</html>