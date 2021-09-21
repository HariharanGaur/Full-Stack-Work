package com.cr7.model.service;


import java.util.ArrayList;
import java.util.Collection;

import com.cr7.bean.Products;

public interface ProductsService {

	public Collection<Products> getAllProdcuts();
	public Products buyProduct(int productId);
	public int productAddtoCart(Products product,int requiredQuantity);
	public int removeFromCart(int id,int requiredQuantity,ArrayList<Products> products);
}
