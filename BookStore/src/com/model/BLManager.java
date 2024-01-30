package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.common.HU;
import com.pojo.Admin;
import com.pojo.Books;
import com.pojo.Order;
import com.pojo.Register;

public class BLManager {

	public static SessionFactory s=HU.sf;

	public void saveRegister(Register r) {
		
		Session s1=s.openSession();
		Transaction t=s1.beginTransaction();
		s1.save(r);
		t.commit();
		s1.close();
	}

	public Register searchByEmailPass(String e, String p) {
		
		Session s1=s.openSession();
		Criteria criteria=s1.createCriteria(Register.class);
		criteria.add(Restrictions.eq("email", e));
		criteria.add(Restrictions.eq("password", p));
		Register r=(Register)criteria.uniqueResult();
		return r;
	}

	public Admin searchByEmailPassAdmin(String u, String p) {
		Session s1=s.openSession();
		Criteria criteria=s1.createCriteria(Admin.class);
		criteria.add(Restrictions.eq("username", u));
		criteria.add(Restrictions.eq("password", p));
		Admin admin=(Admin)criteria.uniqueResult();
		return admin;
	}

	public void saveBook(Books b) {
		Session s1=s.openSession();
		Transaction t=s1.beginTransaction();
		s1.save(b);
		t.commit();
		s1.close();
		
	}
public List<Books> showAllBooks()
{
	Session s1=s.openSession();
	Criteria criteria=s1.createCriteria(Books.class);
	List<Books> blist=criteria.list();
	return blist;
}

public Books searchSingleBook(int bid) {
	Session s1=s.openSession();
	Criteria criteria=s1.createCriteria(Books.class);
	criteria.add(Restrictions.eq("bid", bid));
	
	Books book=(Books)criteria.uniqueResult();
	return book;
}

public void placedOredr(Order o) {
	Session s1=s.openSession();
	Transaction t=s1.beginTransaction();
	s1.save(o);
	t.commit();
	s1.close();
	
}
	
}
