package com.cr7.model.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cr7.bean.Customers;

public interface CustomerDao {
	public Customers getCustomer(String customerName, String customerPassword) throws ClassNotFoundException, SQLException, IOException;
	public boolean addNewCustomerToDb(Customers customer) ;
	public ArrayList<Customers> getAllCustomers();
	
}
