package com.sathya.test;

import com.sathya.dao.CustomerDao;
import com.sathya.dao.CustomerImple;

public class Test {

	public static void main(String[] args) 
	{
		CustomerDao d=new CustomerImple();
		d.saveCustomerWithLoans();
		
        		
		

	}

}
