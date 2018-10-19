package com.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.GuideMeDAO;


@WebServlet("/GuideMe")
public class GuideMe extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String question = request.getParameter("question");
		String date = request.getParameter("date");
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		GuideMeDAO guide = new GuideMeDAO();
		
		guide.insert(email, question, date);
		
		response.sendRedirect("myAnswers.jsp");
		
	}

}
