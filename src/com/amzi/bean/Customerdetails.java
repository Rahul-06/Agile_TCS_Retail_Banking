package com.amzi.bean;

public class Customerdetails {
           private Integer ssn_id;
           private Integer cust_id;
           private String cust_name;
           private String status;
           private String message;
           private String last_u;
         
        public Customerdetails() {
       	}  
        
        public Customerdetails(Integer ssn_id, Integer cust_id, String cust_name, String status, String message, String last_u)
        {
        	this.ssn_id = ssn_id;
        	this.cust_id = cust_id;
        	this.cust_name = cust_name;
        	
        	this.status = status;
        	this.message = message;
        	this.last_u = last_u;
        }
        
        public Integer getSsn_id() {
			return ssn_id;
		}
		public void setSsn_id(Integer ssn_id) {
			this.ssn_id = ssn_id;
		}
		public String getCust_name() {
			return cust_name;
		}
		public void setCust_name(String cust_name) {
			this.cust_name = cust_name;
		}
		public Integer getCust_id() {
			return cust_id;
		}
		public void setCust_id(Integer cust_id) {
			this.cust_id = cust_id;
		}
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setLast_u(String last_u) {
			this.last_u = last_u;
		}
		public String getLast_u() {
			return last_u;
		}
		public void setMessage(String message) {
			this.message = message;
		}

}
