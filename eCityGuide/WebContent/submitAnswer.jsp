<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Submit your answer</title>
</head>
<body>
<%
String question_id = request.getParameter("R1");
session.setAttribute("id", question_id);
%>
<h3>Submit your answer here:</h3>
<form action="HelpThem" method="post">
<textarea rows="10" cols="75" name="answer"></textarea><br>
<b>Date:</b> <input type="date" name="date"><br><br>
<input type="submit" value="Submit">
</form>
</body>
</html>