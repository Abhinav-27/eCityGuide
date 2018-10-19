<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Submit your rating</title>
</head>
<body>
<%
String answer_id = request.getParameter("R1");
session.setAttribute("id", answer_id);
%>
<h3>Submit your rating here:</h3>
<form action="Rating" method="post">
<b>Rating:</b>
<select name="rating">
<option value="Best">Best</option>
<option value="Better">Better</option>
<option value="Good">Good</option>
<option value="Okay">Okay</option>
<option value="Not okay">Not okay</option>
</select><br><br>
<b>Date:</b><input type="date" name="date"><br><br>
<input type="submit" value="Submit">
</form>
</body>
</html>