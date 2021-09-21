package com.cr7.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cr7.bean.Customers;

public class CustomerRowMapper implements RowMapper<Customers> {

	@Override
	public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customers customer=new Customers();
		customer.setCustomerId(rs.getInt("customer_id"));
		customer.setCustomerName(rs.getString("customer_name"));
		customer.setCustomerAddress(rs.getString("customer_address"));
		customer.setCustomerNumber(rs.getString("customer_phone"));
		customer.setCustomerPassword(rs.getString("customer_password"));
		return customer;
	}

}
