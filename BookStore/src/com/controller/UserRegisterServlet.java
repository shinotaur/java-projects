package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Register;


public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String n=request.getParameter("name");
		String e=request.getParameter("email");
		String p=request.getParameter("pass");
		String add=request.getParameter("address");
		
		Register r=new Register();
		r.setName(n);
		r.setEmail(e);
		r.setPassword(p);
		r.setAddress(add);
		
		BLManager bl=new BLManager();
		bl.saveRegister(r);
		response.sendRedirect("UserLogin.jsp");
}
}