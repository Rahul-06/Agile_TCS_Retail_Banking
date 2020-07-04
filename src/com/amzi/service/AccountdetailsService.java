package com.amzi.service;
import com.amzi.bean.Account;
import com.amzi.bean.Account_details;
import com.amzi.bean.Customer;
import com.amzi.dao.AccountDao;
import com.amzi.dao.AccountdetailsDao;
import com.amzi.dao.CustomerDao;

public class AccountdetailsService {
	public Integer createAccountdetails(Account_details c)
	{
		AccountdetailsDao cd = new AccountdetailsDao();
		return cd.addAccountdetails(c);
	}
	public Integer updateAccountdetails(Account_details c)
	{
		AccountdetailsDao cd = new AccountdetailsDao();
		return cd.updateAccountdetails(c);
	}
}
