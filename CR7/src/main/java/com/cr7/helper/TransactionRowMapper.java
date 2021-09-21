package com.cr7.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cr7.bean.Transactions;

public class TransactionRowMapper implements RowMapper<Transactions> {

	@Override
	public Transactions mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Transactions transaction=new Transactions();
		transaction.setTransactionId(resultSet.getInt("transaction_id"));
		transaction.setCustomerId(resultSet.getInt("customer_id"));
		transaction.setProductId(resultSet.getInt("product_id"));
		transaction.setProductName(resultSet.getString("product_name"));
		transaction.setProductQuantity(resultSet.getInt("product_quantity"));
		transaction.setTimeDate(resultSet.getString("timedate"));
		return transaction;
	}

}
