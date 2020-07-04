package com.amzi.service;

import com.amzi.bean.Account;
import com.amzi.dao.AccountDao;

public class AccountService {
	public Integer createAccount(Account c)
	{
		AccountDao cd = new AccountDao();
		return cd.addAccount(c);
	}
	
	public Account searchId(Integer acnumber)
	{
		AccountDao cd = new AccountDao();
		return cd.searchId(acnumber);
	}
	public Integer deleteAccount(Integer acnumber)
	{
		AccountDao cd = new AccountDao();
		return cd.deleteAccount(acnumber);
	}
}
