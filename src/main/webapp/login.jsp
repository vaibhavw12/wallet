<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
</style>
<body>

<form action="Login" method="post">
<div>
      <table style="margin-left:auto; margin-right:auto; padding-top:150px">
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
        <button type="submit">Login</button>
        </div>
      </div>
       </form>
</body>
</html>