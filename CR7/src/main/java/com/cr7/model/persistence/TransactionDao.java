package com.cr7.model.persistence;


import java.util.Collection;

import com.cr7.bean.Transactions;

public interface TransactionDao {

	
	public boolean updateTable(int productId,int quantity);
	public boolean updateTransaction(int customerId,int productId,String productName,int productQuantity,String time);
	public Collection<Transactions> getAllTransactionsDb(int customerId);
}
