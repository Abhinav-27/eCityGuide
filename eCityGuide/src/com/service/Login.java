package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAO;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		LoginDAO dao = new LoginDAO();
		
		if(dao.check(email, pass)) {
			System.out.println("Success !!");
			
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("guideMe.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
