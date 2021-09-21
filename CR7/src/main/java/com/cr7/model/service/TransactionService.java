package com.cr7.model.service;


import java.util.ArrayList;
import java.util.Map;

import com.cr7.bean.Bill;
import com.cr7.bean.Products;
import com.cr7.bean.Transactions;

public interface TransactionService {
	public boolean updateTable(int productId,int quantity);
	public ArrayList<Transactions> getAllTransactions(int customerId);
	public ArrayList<ArrayList<Transactions>> getSeperateTransactions(int id);
	public Map<Double,ArrayList<Bill>> checkout(ArrayList<Products> products,int customerId);
	public double totalSumGenerator(String type, int unitPrice, int quantity);
	public double taxPercentage(String productCategory);
}
