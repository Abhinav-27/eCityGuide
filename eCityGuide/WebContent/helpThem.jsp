<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Help them</title>
</head>
<body>
<%
String str = (String)session.getAttribute("email");
%>
<%@ page import="java.sql.*" %>
<%@ page import="com.dao.ConnectDB" %>

<h3>Here are the questions from the questioner to be answered...</h3>
<%
ConnectDB d = new ConnectDB();
Connection con = d.ConnecttoDB();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from questions where user_id NOT IN (select id from users where email='"+str+"')");
%>
<form action="submitAnswer.jsp" method="post">
<table>
<tr><th>ID</th><th>Question</th><th>Submit Answer</th></tr>
<%
while(rs.next()){ 
%>
<tr>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(3)%></td>
<td><input type="radio" name="R1" value="<%=rs.getString(1)%> required"></td>
<td><input type="submit" value="Answer"></td>
</tr>
<%
}
%>
</table>
</form>
</body>
</html>