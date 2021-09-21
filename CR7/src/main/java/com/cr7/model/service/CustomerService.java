package com.cr7.model.service;


import com.cr7.bean.Customers;


public interface CustomerService {

	public boolean getCustomer(String customerName,String customerPassword);
	public Customers getCustomerDetails(String customerName,String customerPassword);
	public boolean addNewCustomer(Customers customer);
	
}
