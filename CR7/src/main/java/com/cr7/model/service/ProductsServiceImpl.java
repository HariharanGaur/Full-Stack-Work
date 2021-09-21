package com.cr7.model.service;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr7.bean.Products;
import com.cr7.model.persistence.ProductDaoImplementation;

@Service
public class ProductsServiceImpl implements ProductsService{

	@Autowired
	private ProductDaoImplementation prodDao;
	
	
	@Override
	public ArrayList<Products> getAllProdcuts(){
		Collection<Products> products=new ArrayList<Products>(prodDao.getAllProductsRecords());
		return (ArrayList<Products>) products;
	}
	
	@Override
	public Products buyProduct(int productId){
		Products product=new Products();
		product=prodDao.getProduct(productId);
		return product;		
	}
	
	@Override
	public int productAddtoCart(Products product,int requiredQuantity) {
		try {
		if(product.getProductName()==null)
			return 1;
		else if(product.getProductQuantity()<requiredQuantity||product.getProductQuantity()<1) {
			return 2;
		}
		else {
			return 3;
		}
		}
		catch(NullPointerException e){
			return 1;
		}
	}
	
	@Override
	public int removeFromCart(int id,int removeQuantity,ArrayList<Products> products) {
		int flagFound=0;
		Products product = null;
		for(Products p:products) {
			if(p.getProductId()==id) {
				product=p;
				flagFound=1;
				break;
			}
		}
		if(flagFound==0)
			return 1;
		else if(removeQuantity>product.getProductQuantity()||removeQuantity<1)
			return 2;
		else
			return 3;
	}
}
