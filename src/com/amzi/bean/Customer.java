package com.amzi.bean;

public class Customer {
           private Integer ssn_id;
           private Integer cust_id;
           private String cust_name;
           private Integer age;
           private String address;
           private String city;
           private String state;
         
        public Customer() {
       	}  
        
        public Customer(Integer ssn_id, Integer cust_id, String cust_name, Integer age, String address, String city, String state)
        {
        	this.ssn_id = ssn_id;
        	this.cust_id = cust_id;
        	this.cust_name = cust_name;
        	this.age = age;
        	this.address = address;
        	this.city = city;
        	this.state = state;
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
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}

}
