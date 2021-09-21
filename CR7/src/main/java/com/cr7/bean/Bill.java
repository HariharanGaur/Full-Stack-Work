package com.cr7.bean;

public class Bill {
	int sNo;
	String productName;
	int productQuantity;
	double unitPrice;
	double tax;
	double price;
	public Bill() {
		
	}
	
	public Bill(int sNo,String productName, int productQuantity, double unitPrice, double tax, double price) {
		super();
		this.sNo=sNo;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.unitPrice = unitPrice;
		this.tax = tax;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	
}
