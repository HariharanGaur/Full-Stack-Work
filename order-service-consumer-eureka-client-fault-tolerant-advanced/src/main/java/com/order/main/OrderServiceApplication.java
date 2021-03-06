package com.order.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.order.bean.OrderT1;
import com.order.bean.OrderItem1;
import com.order.service.OrderService;

@SpringBootApplication(scanBasePackages = "com.order")
@EnableJpaRepositories(basePackages = "com.order.persistence")
@EntityScan(basePackages = "com.order.bean")
@EnableEurekaClient
public class OrderServiceApplication {//implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
//	@Autowired
//	OrderService orderService;
//	@Autowired
//	OrderItemService orderItemService;
//	@Override
//	public void run(String... args) throws Exception {
//		
//		  orderItemService.insertOrderItem(new OrderItem1("P001",5));
//		  orderItemService.insertOrderItem(new OrderItem1("P002",5));
//		  orderItemService.insertOrderItem(new OrderItem1("P003",10));
//		  orderItemService.insertOrderItem(new OrderItem1("P004",6));
//		  List<OrderItem1> oi1=Arrays.asList(new OrderItem1("P001",5),new OrderItem1("P002",5),new OrderItem1("P003",10));
//		  orderService.createOrder(new OrderT1("cust1@xmail.com","20,new steet",oi1));
//		  List<OrderItem1> oi2=Arrays.asList(new OrderItem1("P001",5),new OrderItem1("P002",5));
//		  orderService.createOrder(new OrderT1("cust2@xmail.com","556,main road",oi2)); 
//		  List<OrderItem1> oi3=Arrays.asList(new OrderItem1("P001",5),new OrderItem1("P002",5),new OrderItem1("P003",10),new OrderItem1("P004",6));
//		  orderService.createOrder(new OrderT1("cust3@xmail.com","A1, Sun apartments",oi3));
//			  
//	}

}
