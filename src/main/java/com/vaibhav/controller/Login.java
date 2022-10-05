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

@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//response.sendRedirect("index.html");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		//System.out.println(session.getAttribute("email"));
		Database db = new Database();
		if(db.success(email, pass)) {
//			out.print("login success");
//			out.print(Database.name);
			response.sendRedirect("home.jsp");
		}else {
			out.print("some thing went wrong try again");
		}
	}

}
