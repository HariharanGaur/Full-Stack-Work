package com.retail.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retail.bean.InventoryItem;
import com.retail.bean.OrderItem;
import com.retail.bean.OrderT;
import com.retail.bean.ProductList;
import com.retail.bean.Products;

@Service
public class ProductService {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	InventoryService inventoryService;
	@Autowired
	CatalogProdcutsService catalogProductsService;
	@Autowired
	CatalogProductService catalogProductService;
	@Autowired
	OrderService orderService;
	
	public List<Products> getAllProducts() {
		ProductList products=catalogProductsService.getAllProducts();
		return products.getProducts();
	}
	
	public Products getProductByCode(String code) {
		Products product=catalogProductService.getProductByCode(code);
		return product;
	}
	
	public int productAddToCart(String code,int quantity) {
		Products p=catalogProductService.getProductByCode(code);
		InventoryItem inventory=inventoryService.getInventoryByCode(code);
		if(p==null)
			return 1;
		else if(inventory.getProductQuantity()<quantity ) {
			return 2;
		}
		else if(quantity<=0) {
			return 3;
		}
		else {
			return 4;
		}
	}
	
	public OrderT createOrder(OrderT order) {
		System.out.println(order.getCustomerAddress()+"--"+order.getCustomerEmail()+"--\n");
		for(OrderItem o:order.getItems()) {
			System.out.println(o.getProductId()+"--"+o.getProductPrice());
		}
		OrderT o=orderService.createOrder(order);
		for(OrderItem i:o.getItems()) {
			Products product = catalogProductService.getProductByCode(i.getProductId());
			i.setProductPrice(product.getPrice());
		}
		for(OrderItem o1:o.getItems()) {
			System.out.println(o1.getProductId()+"--"+o1.getProductPrice());
		}
		return o;
	}
	public double sumGenerator(OrderT order) {
		List<OrderItem> items=order.getItems();
		double s=0;
		for(OrderItem i:items) {
			s+=i.getProductPrice()*i.getQuantity();
		}
		return s;
		
	}
}
