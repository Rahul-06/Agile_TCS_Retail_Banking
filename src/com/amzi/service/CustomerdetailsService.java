package com.amzi.service;


import com.amzi.bean.Customerdetails;
import com.amzi.dao.CustomerdetailsDao;
public class CustomerdetailsService {
	public Integer createCustomerdetails(Customerdetails c)
	{
		CustomerdetailsDao cd = new CustomerdetailsDao();
		return cd.addCustomerdetails(c);
	}	
	public Integer updateCustomerdetails(Customerdetails c)
	{
		CustomerdetailsDao cd = new CustomerdetailsDao();
		return cd.updateCustomerdetails(c);
	}
}
