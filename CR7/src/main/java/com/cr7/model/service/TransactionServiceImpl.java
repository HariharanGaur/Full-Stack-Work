package com.cr7.model.service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr7.bean.Bill;
import com.cr7.bean.Products;
import com.cr7.bean.Transactions;
import com.cr7.model.persistence.TransactionDaoImplementation;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionDaoImplementation tranDao;
	
	@Override
	public Map<Double,ArrayList<Bill>> checkout(ArrayList<Products> products,int customerId){
		ArrayList<Bill> bill=new ArrayList<Bill>();
		int i=1;
		double totalSum=0,price=0;
		for(Products p:products) {
			Bill b=new Bill();
			totalSum+=totalSumGenerator(p.getProductCategory(), p.getProductPrice(), p.getProductQuantity());
			price=totalSumGenerator(p.getProductCategory(), p.getProductPrice(), p.getProductQuantity());
			b.setsNo(i);
			i++;
			b.setProductName(p.getProductName());
			b.setProductQuantity(p.getProductQuantity());
			b.setUnitPrice(p.getProductPrice());
			b.setTax(taxPercentage(p.getProductCategory()));
			b.setPrice(price);
			bill.add(b);
			updateTable(p.getProductId(),p.getProductQuantity());
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime time=LocalDateTime.now();
			String dateTime = time.format(format); 
			tranDao.updateTransaction(customerId, p.getProductId(), p.getProductName(), p.getProductQuantity(), dateTime);
		}
		Map<Double,ArrayList<Bill>> finalBill=new HashMap<Double,ArrayList<Bill>>();
		finalBill.put(totalSum, bill);
		return finalBill;
		
	}
	
	@Override
	public double totalSumGenerator(String type,int unitPrice, int quantity) {
		double tax=taxPercentage(type);
		double total=((quantity * unitPrice) + tax) ;
		return total;
	}
	
	@Override
	public double taxPercentage(String productCategory) {
		if(productCategory.equalsIgnoreCase("Cds"))
			return 10;
		else if(productCategory.equalsIgnoreCase("Cosmetics"))
			return 12;
		else if(productCategory.equalsIgnoreCase("Books"))
			return 0;
		return 0;
	}
	
	@Override
	public boolean updateTable(int productId, int quantity){
		return tranDao.updateTable(productId, quantity);
		
	}
	
	@Override
	public ArrayList<Transactions> getAllTransactions(int customerId){
		ArrayList<Transactions> transactions=(ArrayList<Transactions>) tranDao.getAllTransactionsDb(customerId);
		return transactions;
	}
	@Override
	public ArrayList<ArrayList<Transactions>> getSeperateTransactions(int id){
		ArrayList<ArrayList<Transactions>> trans=new ArrayList<ArrayList<Transactions>>();
		ArrayList<Transactions> transactions=(ArrayList<Transactions>) tranDao.getAllTransactionsDb(id);
		for(int i=0;i<transactions.size();i++) {
			ArrayList<Transactions> tempTranList=new ArrayList<Transactions>();
			for(int j=0;j<transactions.size();j++) {
				Transactions tempTran=new Transactions();
				if(i!=j && transactions.get(i).getTimeDate()==transactions.get(j).getTimeDate()) {
					tempTran=transactions.get(j);
					tempTranList.add(tempTran);
					transactions.set(j, new Transactions());
				}
				trans.add(tempTranList);	
			}
		}
		return trans;
	}
}
