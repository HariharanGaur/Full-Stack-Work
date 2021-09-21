package com.cr7.model.persistence;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cr7.bean.Transactions;
import com.cr7.helper.TransactionRowMapper;


@Repository
public class TransactionDaoImplementation implements TransactionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	

	@Override
	public boolean updateTable(int productId, int quantity){
		int rows=jdbcTemplate.update("UPDATE products SET product_quantity=product_quantity-? WHERE product_id=?",quantity,productId);
		if (rows > 0)
			return true;
		return false;
	}

	

	

	@Override
	public boolean updateTransaction(int customerId,int productId,String productName,int productQuantity,String time) {
		int rows=jdbcTemplate.update("INSERT INTO transactions(customer_id,product_id,product_name,product_quantity,timedate) values(?,?,?,?,?)",customerId,productId,productName,productQuantity,time);
		if (rows > 0)
			return true;
		return false;
	}
	
	@Override
	public Collection<Transactions> getAllTransactionsDb(int customerId){
		try{
			List transactions=jdbcTemplate.query("SELECT * FROM transactions where customer_id=?",new TransactionRowMapper(),customerId);
			return  transactions;
			}
			catch(EmptyResultDataAccessException ex) {
				return null;
			}
	}
}
