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


@WebServlet("/Debit")
public class Debit extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//response.sendRedirect("index.html");
		String amount = request.getParameter("amount");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		//System.out.println(amount + "," + email);
		if(Database.debitBalance(email,amount)) {
			out.print("<h1 style='text-align:center;padding-top:50px'>");
			out.print("amount debited successfully");
			out.print("<br>");
			out.print("<a href='home.jsp'>click here</a>");
			out.print("</h1>");
		}else {
			out.print("<h1 style='text-align:center;padding-top:50px'>");
			out.println("transction denied");
			out.print("<br>");
			out.print("<a href='home.jsp'>click here</a>");
			out.print("</h1>");
		}
		
	}

}
