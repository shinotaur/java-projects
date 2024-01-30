package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Register;

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String e=request.getParameter("email");
		String p=request.getParameter("pass");
		
		Register r=new Register();
		BLManager bl=new BLManager();
		r=bl.searchByEmailPass(e,p);
		
		if(r!=null)
		{
			HttpSession sl=request.getSession();
			sl.setAttribute("em", r);
			response.sendRedirect("Index.jsp");
		}
		else
		{
			response.sendRedirect("UserLogin.jsp");
		}
		
	}

}
