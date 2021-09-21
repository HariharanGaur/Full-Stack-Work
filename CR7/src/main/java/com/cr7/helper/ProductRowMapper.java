package com.cr7.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cr7.bean.Products;

public class ProductRowMapper implements RowMapper<Products>{

	@Override
	public Products mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Products product=new Products();
		product.setProductId(resultSet.getInt("product_id"));
		product.setProductName(resultSet.getString("product_name"));
		product.setProductCategory(resultSet.getString("product_category"));
		product.setProductPrice(resultSet.getInt("product_price"));
		product.setProductQuantity(resultSet.getInt("product_quantity"));
		return product;
	}

}
