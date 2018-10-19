<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My questions !!</title>
</head>
<body>
<%
String str = (String) session.getAttribute("email");
%>
<%@ page import="java.sql.*"%>
<%@ page import="com.dao.ConnectDB"%>

<h3>Here are the answers for the questions which had been attended by you...</h3>
<h4><a href="myAwards.jsp" style="float: right;">Wanna check ratings for your answers?</a></h4>
<%
ConnectDB d = new ConnectDB();
Connection con = d.ConnecttoDB();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select title, answer_text from questions q, answers a where q.id = a.question_id and title IN (select title from questions q, answers a where q.id = a.question_id and q.id IN(select id from questions where user_id NOT IN(select id from users where email='"+str+"')) and a.user_id IN(select id from users where email='"+str+"'))");
%>
<table>
<tr><th>Questions</th><th></th><th></th><th>Answers</th></tr>
<%
while(rs.next()) {
%>
<tr>
<td><%=rs.getString(1)%></td>
<td></td>
<td></td>
<td><%=rs.getString(2)%></td>
</tr><tr></tr>
<%
}
%>
</table>
</body>
</html>