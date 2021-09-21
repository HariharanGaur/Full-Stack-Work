package com.cr7.helper;

import java.util.Scanner;

import com.cr7.bean.Customers;

public class Helper {
	Scanner sc=new Scanner(System.in);
	public Customers newCustomer() {
		Customers customer=new Customers();
		System.out.println("Enter Your name please");
		String customerName=sc.nextLine();
		System.out.println("Enter your password");
		String customerPassword=sc.nextLine();
		while(true) {
			System.out.println("Confirm your password");
			String temp=sc.nextLine();
			if(temp.equals(customerPassword))
				break;
			else
				System.err.println("Sorry both passwords don't match! Please confirm your password again!");
		}
		System.out.println("Enter your address:");
		String customerAddress=sc.nextLine();
		System.out.println("Enter your phone number");
		String customerNumber=sc.nextLine();
		customer.setCustomerName(customerName);
		customer.setCustomerPassword(customerPassword);
		customer.setCustomerAddress(customerAddress);
		customer.setCustomerNumber(customerNumber);
		return customer;
	}
}
