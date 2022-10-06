<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.vaibhav.info.Database"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>my balance</title>
</head>
<body>
<%
if((session.getAttribute("email")==null)){
	response.sendRedirect("index.html");
}
%>
<%
HttpSession session_1 = request.getSession();
String email =(String) session.getAttribute("email");
//System.out.println(email+" bal");
String balance = Database.giveBalance(email);
out.print("<h1 style='text-align:center;padding-top:150px'>");
out.print(balance);
out.print("<br>");
out.print("<a href='home.jsp'>click here</a>");
out.print("</h1>");
%>
</body>
</html>