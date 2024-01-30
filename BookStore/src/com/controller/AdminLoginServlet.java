package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Admin;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String u=request.getParameter("uname");
		String p=request.getParameter("pass");
		
		Admin admin=new Admin();
		BLManager bl=new BLManager();
		
		admin=bl.searchByEmailPassAdmin(u,p);
		
		if(admin != null)
		{
			HttpSession sa=request.getSession();
			sa.setAttribute("admin", admin);
			response.sendRedirect("AddBooks.jsp"); 
		}
		else
		{
			response.sendRedirect("AdminLogin.jsp");
		}
				
	}

}
