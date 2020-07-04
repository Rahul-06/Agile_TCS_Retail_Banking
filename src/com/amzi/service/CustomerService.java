
package com.amzi.service;

import com.amzi.bean.Customer;
import com.amzi.dao.CustomerDao;

public class CustomerService {
	
	public Integer createCustomer(Customer c)
	{
		CustomerDao cd = new CustomerDao();
		return cd.addCustomer(c);
	}
	
	public Customer searchId(Integer cust_id)
	{
		CustomerDao cd = new CustomerDao();
		return cd.searchId(cust_id);
	}
	
	public Integer updateCustomer(Customer c)
	{
		CustomerDao cd = new CustomerDao();
		return cd.updateCustomer(c);
	}
	
	public Integer deleteCustomer(Integer cust_id)
	{
		CustomerDao cd = new CustomerDao();
		return cd.deleteCustomer(cust_id);
	}
	
	/* VIEW CUSTOMER */
	
	public Customer viewCustomer(String ssn_id, String cust_id)
	{
		CustomerDao cd = new CustomerDao();
		return cd.viewId(ssn_id,cust_id);
		
	}
	
}
