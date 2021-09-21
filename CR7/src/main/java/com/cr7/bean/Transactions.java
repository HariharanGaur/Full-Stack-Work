package com.cr7.bean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//POJO :Plain Old Java Object / JavaBean
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Transactions {

	private int transactionId;
	private int customerId;
	private int productId;
	private String productName;
	private int productQuantity;
	private String timeDate;
	public Transactions() {
		// TODO Auto-generated constructor stub
	}
	public Transactions(int transactionId, int customerId, int productId, String productName, int productQuantity,
			String timeDate) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.timeDate = timeDate;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public String getTimeDate() {
		return timeDate;
	}
	public void setTimeDate(String timeDate) {
		this.timeDate = timeDate;
	}
	
}
