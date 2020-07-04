package com.amzi.bean;

public class Account {
	private Integer cust_id;
    private Integer acnumber;
    private String acc_type;
    private Integer deposit;
    public Account() {
   	}  
    
    public Account(Integer acnumber,String acc_type,Integer cust_id, Integer deposit)
    {
    	
    	this.cust_id = cust_id;
    	this.acnumber = acnumber;
    	this.deposit = deposit;
    	this.acc_type=acc_type;
    	
    }
    
   
	public Integer getAcnumber() {
		return acnumber;
	}
	public void setAcnumber(Integer acnumber) {
		this.acnumber= acnumber;
	}
	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type)
	{
		this.acc_type=acc_type;
	}
	public Integer getDeposit() {
		return deposit;
	}
	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}
	
}
