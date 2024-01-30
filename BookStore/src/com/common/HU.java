package com.common;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HU {

	public static SessionFactory sf;
	
	static
	{
		try
		{
			
			sf=new Configuration().configure().buildSessionFactory();
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
