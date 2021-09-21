package com.cr7.model.persistence;


import java.util.Collection;

import com.cr7.bean.Products;

public interface ProductDao {
	public Collection<Products> getAllProductsRecords();
	public Products getProduct(int productId) ;
}
