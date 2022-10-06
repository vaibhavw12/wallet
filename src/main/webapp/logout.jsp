<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="com.vaibhav.info.Database,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if((session.getAttribute("email")==null)){
	response.sendRedirect("index.html");
}
%>
<%
HttpSession session_2 = request.getSession();
String email =(String) session.getAttribute("email");
//System.out.println(email+" bal");

%>
<form action="Logout" method="post">
<h1 style='text-align:center;padding-top:50px'>
do you want to log out ?<br>
<button type="submit">Logout</button>
</h1>
</form>
</body>
</html>