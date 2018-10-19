package com.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RegistrationDAO;


@WebServlet("/Register")
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mob = request.getParameter("mob");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String date = request.getParameter("date");
		
		RegistrationDAO reg = new RegistrationDAO();
		
		reg.insert(fname, lname, mob, email, pass, date);
		
		HttpSession session = request.getSession();
		session.setAttribute("fname", fname);
		
		response.sendRedirect("login.jsp");
		
	}

}
