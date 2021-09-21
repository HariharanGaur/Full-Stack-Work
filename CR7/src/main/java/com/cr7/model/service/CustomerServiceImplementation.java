package com.cr7.model.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr7.bean.Customers;
import com.cr7.helper.Helper;
import com.cr7.model.persistence.CustomerDaoImplementation;

@Service
public class CustomerServiceImplementation implements CustomerService{
	
	@Autowired
	private CustomerDaoImplementation custDao;


	@Override
	public boolean getCustomer(String customerName,String customerPassword){
		
		if(custDao.getCustomer(customerName, customerPassword)==null)
			return false;
		
		return true;
	}
	@Override
	public Customers getCustomerDetails(String customerName, String customerPassword) {
		Customers customer=new Customers();
		customer=custDao.getCustomer(customerName, customerPassword);
		return customer;
	}

	@Override
	public boolean addNewCustomer(Customers customer){
		ArrayList<Customers> customers=custDao.getAllCustomers();
		for(Customers c:customers) {
			if(c.getCustomerName().equalsIgnoreCase(customer.getCustomerName())) {
				return false;
			}
		}
		return custDao.addNewCustomerToDb(customer);		
	}


}
