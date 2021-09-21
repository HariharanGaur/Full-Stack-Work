package com.cr7.model.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cr7.bean.Customers;
import com.cr7.helper.CustomerRowMapper;

@Repository
public class CustomerDaoImplementation implements CustomerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Customers getCustomer(String customerName,String customerPassword){
		try {
			Customers customer=jdbcTemplate.queryForObject("Select * from customers where customer_name=? AND customer_password=?", new CustomerRowMapper(),customerName,customerPassword);
			return customer;
		}
		catch(EmptyResultDataAccessException ex){
			return null;
		}
	}
	
	@Override
	public boolean addNewCustomerToDb(Customers customer){
		int rows=jdbcTemplate.update("INSERT INTO customers(customer_name,customer_address,customer_phone,customer_password) values(?,?,?,?)", customer.getCustomerName(),customer.getCustomerAddress(),customer.getCustomerNumber(),customer.getCustomerPassword());
		if (rows > 0)
			return true;
		return false;
		
	}

	@Override
	public ArrayList<Customers> getAllCustomers() {
		List<Customers> customers=jdbcTemplate.query("select * from customers", new CustomerRowMapper());
		return (ArrayList<Customers>) customers;
	}
}
