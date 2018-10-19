<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
<center><h1>Registration</h1></center>
<center>
<form action="Register" method="post">
<table>
<tr><td><b>First Name:</b></td><td><input type="text" name=fname></td></tr>
<tr><td><b>Last Name:</b></td><td><input type="text" name=lname></td></tr>
<!-- <tr><td><b>Gender:</b></td><td><input type="radio" name= "gender" value="Male" checked>Male
        <input type="radio" name="gender" value="Female">Female
        <input type="radio" name="gender" value="Others">Others</td></tr> -->
<tr><td><b>Mobile Number:</b></td><td><input type="number" name="mob"></td></tr>
<tr><td><b>Email:</b></td><td><input type="email" name="email"></td></tr>
<tr><td><b>Password:</b></td><td><input type="password" name="pass"></td></tr>
<tr><td><b>Confirm password:</b></td><td><input type="password" name="confirmpass"></td></tr>
<tr><td><b>Date:</b></td><td><input type="date" name="date"></td></tr>
</table>
<input type="submit" value="Register">
</form>
</center>
</body>
</html>