<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My answers !!</title>
</head>
<body>
<%
String str = (String) session.getAttribute("email");
%>
<%@ page import="java.sql.*" %>
<%@ page import="com.dao.ConnectDB" %>

<h3>Here are the answers which has been answered for the questions being asked...</h3>
<%
ConnectDB d = new ConnectDB();
Connection con = d.ConnecttoDB();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select title, a.id, answer_text from questions q,answers a where q.id =a.question_id and q.user_id IN (select id from users where email='"+str+"')");
%>
<form action="submitRating.jsp" method="post">
<table>
<tr><th>Questions</th><th></th><th>ID</th><th></th><th>Answers</th><th>Submit Rating</th></tr>
<%
while(rs.next()) {
%>
<tr>
<td><%=rs.getString(1)%></td>
<td></td>
<td><%=rs.getString(2)%></td>
<td></td>
<td><%=rs.getString(3)%></td>
<td><input type="radio" name="R1" value="<%=rs.getString(2)%> required"></td>
<td><input type="submit" value="Rating"></td>
</tr>
<%
}
%>
</table>
</form>
</body>
</html>