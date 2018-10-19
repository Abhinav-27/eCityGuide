package com.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.HelpThemDAO;


@WebServlet("/HelpThem")
public class HelpThem extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answer = request.getParameter("answer");
		String date = request.getParameter("date");
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String temp1 = (String) session.getAttribute("id");
		String temp2 = temp1.replaceAll("[^\\d]", "");
		int question_id = Integer.parseInt(temp2);
		
		HelpThemDAO help = new HelpThemDAO();
		
		help.insert(email, question_id, answer, date);
		
		response.sendRedirect("myQuestions.jsp");
	}

}
