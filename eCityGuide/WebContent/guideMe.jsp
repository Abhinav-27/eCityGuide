<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guide Me :)</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-validate");  //HTTP 1.1

response.setHeader("pragma", "no-cache"); //HTTP 1.0

response.setHeader("Expires", "0"); //Proxies

if(session.getAttribute("email")==null) {
	response.sendRedirect("login.jsp");
}

session.getAttribute("fname");
%>

Welcome ${fname}<br><br><br><br>

<h4><a href="helpThem.jsp" style="float: right;">Wanna help someone ?</a></h4>

<h3>Ask your question:</h3>

<form action="GuideMe" method="post">
<textarea rows="10" cols="75" name="question"></textarea><br>
<b>Date:</b> <input type="date" name="date"><br><br>
<h4><a href="myAnswers.jsp" style="float: right;">Wanna rate someone ?</a></h4>
<input type="submit" value="Submit">
</form>
<h4><a href="myAwards.jsp" style="float: right;">Wanna check ratings for your answers?</a></h4>
<br><br><br><br>
<form action="Logout">
<br>
<input type="submit" value="Logout">
</form>

</body>
</html>