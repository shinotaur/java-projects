package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Books;
import com.pojo.Register;

public class BuyNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String b=request.getParameter("bid");
		int bid=Integer.parseInt(b);
		Books book=new Books();
		BLManager bl=new BLManager();
		book=bl.searchSingleBook(bid);
		
		if(book!=null)
		{
			HttpSession sb=request.getSession();
			sb.setAttribute("book", book);
			response.sendRedirect("ShowSingleBookDetails.jsp");
		}
		else
		{
			response.sendRedirect("UserLogin.jsp");
		}
	}

}
