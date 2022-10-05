<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.vaibhav.info.Database"%>
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
HttpSession session_1 = request.getSession();
String email =(String) session.getAttribute("email");
//Database.updateBalance(email);
%>

<form action="Credit" method="post">
<div>
      <table style="margin-left:auto; margin-right:auto; padding-top:150px">
      <tr> 
      <th><label for="number"><b>amount</b></label></th>
      <th><input type="number" placeholder="Enter amount" name="amount" required></th>
      </tr>
      
      </table>
      <div style=text-align:center;padding-top:5px>
      <a href="home.jsp"><button type="button">Cancel</button></a>
        <button type="submit">credit amount</button>
        </div>
      </div>
       </form>
</body>
</html>