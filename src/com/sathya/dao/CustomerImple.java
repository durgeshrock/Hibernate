package com.sathya.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sathya.entity.Customer;
import com.sathya.entity.Loan;

import co.sathya.util.HibernateUtil;

public class CustomerImple implements CustomerDao {
   private SessionFactory factory;
   
	public CustomerImple()
	{
	factory=HibernateUtil.getSessionfactory();	
	}
	
	
	@Override
	public void saveCustomerWithLoans() {
		Session session=factory.openSession();
		Customer c=new Customer();
		c.setCustId(101);
		Loan l1=new Loan();
		l1.setLoanId("k011");
		l1.setLoanAmount(9090);
		Loan l2=new Loan();
		l2.setLoanId("k012");
		l2.setLoanAmount(9094);
		Set<Loan> loans=new HashSet();
		Transaction tx=session.beginTransaction();
		
		loans.add(l1);
		loans.add(l2);
		
		c.setLoans(loans);
		session.save(c);
		tx.commit();
	}
		public void removeloanAttribute()
		{
		    Session session1=factory.openSession();
		    Customer c=(Customer)session1.get(Customer.class,101);
		    Set loans=c.getLoans();
		    Transaction tx=session1.beginTransaction();
		    Loan l=(Loan)session1.get(Loan.class,"k011");
		    loans.remove(l);
		    tx.commit();
		    
		    
		    
		    
		    
		    
		}
	public  void selectCustomerById(int custid)
	{
		Session session=factory.openSession();
		Customer c=(Customer)session.get(Customer.class,custid);
		     session.close();
		
		
	}
		
		

	

}
