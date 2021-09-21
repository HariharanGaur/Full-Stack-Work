package com.cr7.model.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cr7.bean.Products;
import com.cr7.helper.ProductRowMapper;

@Repository
public class ProductDaoImplementation implements ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Collection<Products> getAllProductsRecords(){
		List<Products> products=jdbcTemplate.query("SELECT * FROM products",new ProductRowMapper());
		return products;
	}
	
	@Override
	public Products getProduct(int productId){
		try{
			Products product=jdbcTemplate.queryForObject("SELECT * FROM products WHERE product_id=?",new ProductRowMapper(),productId);
			return product;
			}
			catch(EmptyResultDataAccessException ex) {
				return null;
			}
	}
}
