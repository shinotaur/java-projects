package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Books;

public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String aname=request.getParameter("aname");
		String p=request.getParameter("price");
		double price=Double.parseDouble(p);
	
		Books b=new Books();
		b.setBookId(bookid);
		b.setBookname(bname);
		b.setAuthorName(aname);
		b.setPrice(price);
		
		BLManager bl=new BLManager();
		bl.saveBook(b);
		response.sendRedirect("AddBooks.jsp");
	}

}
