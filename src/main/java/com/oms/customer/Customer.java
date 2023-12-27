package com.oms.customer;

import java.util.Date;

import com.oms.address.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name= "online_customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private int customerId;

	@Column(name = "CUSTOMER_FNAME")
	private String customerFirstName;

	@Column(name = "CUSTOMER_LNAME")
	private String customerLastName;

	@Column(name = "CUSTOMER_EMAIL")
	private String customerEmail;

	@Column(name = "CUSTOMER_PHONE")
	private long customerPhone;

	

	@Column(name = "CUSTOMER_CREATION_DATE")
	private Date customerCreationDate;

	@Column(name = "CUSTOMER_USERNAME")
	private String customerUsername;

	@Column(name = "CUSTOMER_GENDER")
	private char customerGender;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address address;

   
	 
	 public Address getAddress() {
	        return address;
	    }

	    public void setAddress(Address address) {
	        this.address = address;
	    }


	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public long getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}

	

	public Date getCustomerCreationDate() {
		return customerCreationDate;
	}

	public void setCustomerCreationDate(Date customerCreationDate) {
		this.customerCreationDate = customerCreationDate;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public char getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(char customerGender) {
		this.customerGender = customerGender;
	}
	
	

	public Customer() {
		super();
	}

	public Customer( String customerFirstName, String customerLastName, String customerEmail,
			long customerPhone, Date customerCreationDate, String customerUsername,
			char customerGender) {
		super();

		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		
		this.customerCreationDate = customerCreationDate;
		this.customerUsername = customerUsername;
		this.customerGender = customerGender;
	}

	

}
