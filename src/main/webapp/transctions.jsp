<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="com.vaibhav.info.Database,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recent Transactions</title>
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
ArrayList<String> trans = Database.printTranctions(email);
for(int i = trans.size()-1;i>=0;i--){
//for(int i=0;i<trans.size();i++){
	out.print(trans.get(i));
	out.print("<br>");

}
out.print("<br>");
out.print("<a href='home.jsp'>click here</a>");
%>

</body>
</html>