package com.cr7.bean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//POJO :Plain Old Java Object / JavaBean
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Customers {

	private int customerId;
	private String customerName;
	private String customerAddress;
	private String customerNumber;
	private String customerPassword;
	
	public Customers() {
		// TODO Auto-generated constructor stub
	}

	public Customers(int customerId, String customerName, String customerAddress, String customerNumber,
			String customerPassword) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerNumber = customerNumber;
		this.customerPassword = customerPassword;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
}
