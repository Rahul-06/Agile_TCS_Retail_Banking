package com.amzi.bean;


public class Account_details {
	private Integer cust_id;
    private Integer acnumber;
    private String acc_type;
    private String status;
    private String message;
    private String last_u;
    public Account_details() {
   	}  
    
    public Account_details(Integer acnumber,Integer cust_id,String acc_type,String status,String message,String last_u )
    {
    	
    	this.cust_id = cust_id;
    	this.acnumber = acnumber;
        this.status=status;
        this.message=message;
    	this.acc_type=acc_type;
    	this.last_u=last_u;
    	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status)
	{
		this.status=status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message)
	{
		this.message=message;
	}
	public String getLast_u() {
		return last_u;
	}
	public void setLast_u(String last_u)
	{
		this.last_u=last_u;
	}
}
