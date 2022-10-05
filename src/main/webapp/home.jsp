<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<%
if((session.getAttribute("email")==null)){
	response.sendRedirect("index.html");
}
%>

<div style=text-align:center;padding-top:250px>
      <a href="balance.jsp"><button type="button">check balance</button></a><br><br>
      <a href="credit.jsp"><button type="button">credit money</button></a><br><br>
      <a href="debit.jsp"><button type="button">debit money</button></a><br><br>
      <a href="transctions.jsp"><button type="button">my transctions</button></a><br><br>
      <a href="logout.jsp"><button type="button">Logout</button></a><br>
        </div>
</body>
</html>