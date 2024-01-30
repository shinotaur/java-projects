package com.controller;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Books;
import com.pojo.Order;
import com.pojo.Register;

@MultipartConfig(maxFileSize = 16175455)
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Random RANDOM = new SecureRandom();
	public static final int PASSWORD_LENGTH = 8;
	public static String generateRandomPassword()
	{
		 String letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		 String pw="";
		 for(int i=0;i<PASSWORD_LENGTH;i++)
			 {
			 int index = (int)(RANDOM.nextDouble()*letters.length());
			 pw += letters.substring(index, index+1);
			 }
		 return pw;
				 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ord=ConfirmServlet.generateRandomPassword();
		Date date=new Date();
		HttpSession sl=request.getSession();
		Register r=(Register)sl.getAttribute("em");
		HttpSession sb=request.getSession();
		Books b=(Books)sb.getAttribute("book");
		
		Order o=new Order();
		o.setOrderId(ord);
		o.setOrderDate(date);
		o.setRegister(r);
		o.setBooks(b);
		
		BLManager bl=new BLManager();
		bl.placedOredr(o);
		response.sendRedirect("ThankYou.jsp");
		
		
		
	}

}
