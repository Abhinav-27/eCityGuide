package com.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RatingDAO;


@WebServlet("/Rating")
public class Rating extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rating = request.getParameter("rating");
		String date = request.getParameter("date");
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		String temp1 = (String)session.getAttribute("id");
		String temp2 = temp1.replaceAll("[^\\d]", "");
		int answer_id = Integer.parseInt(temp2);
		
		RatingDAO rate = new RatingDAO();
		
		rate.insert(email, answer_id, rating, date);
		
		response.sendRedirect("myFeedback.jsp");
	}

}
