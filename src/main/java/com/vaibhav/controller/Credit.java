package com.vaibhav.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaibhav.info.Database;


@WebServlet("/Credit")
public class Credit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//response.sendRedirect("index.html");
		String amount = request.getParameter("amount");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		//System.out.println(amount + "," + email);
		if(Database.updateBalance(email,amount)) {
			out.print("amount credited successfully");
			out.print("<br>");
			out.print("<a href='home.jsp'>click here</a>");
		}else {
			out.print("transction denied");
			out.print("<br>");
			out.print("<a href='home.jsp'>click here</a>");
		}
		
	}

}
