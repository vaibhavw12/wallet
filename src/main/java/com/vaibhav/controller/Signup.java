package com.vaibhav.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaibhav.info.Database;
import com.vaibhav.info.User;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//response.sendRedirect("index.html");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		User user = new User();
		user.setEmail(email);
		user.setPhone(phone);
		user.setName(name);
		user.setPassword(pass);
		user.setBalance("0");
		
		//System.out.println(user.getBalance());
		
		Database db = new Database();
		if(db.save(user)) {
			out.print("good to go");
		}else {
			out.print("email aleready exist try login");
		}
		
	}

}
