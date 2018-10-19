<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My awards !!</title>
</head>
<body>
<%
String str = (String) session.getAttribute("email");
%>
<%@ page import="java.sql.*"%>
<%@ page import="com.dao.ConnectDB"%>

<h3>Here are the ratings for your answers to the questions...</h3>
<%
ConnectDB d = new ConnectDB();
Connection con = d.ConnecttoDB();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select title, answer_text, rating from rating r, answers a, questions q, users u where r.user_id = u.id and r.question_id = q.id and r.answer_id = a.id and a.user_id IN(select id from users where email='"+str+"')");
%>
<table>
<tr><th>Question</th><th>Answer</th><th>Rating</th></tr>
<%
while(rs.next()) {
%>
<tr>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3)%></td>
</tr><tr></tr>
<%
}
%>
</table>
</body>
</html>