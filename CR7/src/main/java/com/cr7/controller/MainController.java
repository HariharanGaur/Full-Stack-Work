package com.cr7.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cr7.bean.Bill;
import com.cr7.bean.Customers;
import com.cr7.bean.Products;
import com.cr7.bean.Transactions;
import com.cr7.model.service.CustomerService;
import com.cr7.model.service.ProductsService;
import com.cr7.model.service.TransactionService;

@Controller
@SessionAttributes({"customerlogin"})
public class MainController {

	@Autowired
	CustomerService customerService;
	@Autowired
	ProductsService productsService;
	@Autowired
	TransactionService transactionService;
	Customers customerGlobal;
	
	ArrayList<Products> products=new ArrayList<Products>();
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView indexPage() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/l")
	public ModelAndView welcomePageController() {
		return new ModelAndView("login","customerlogin",new Customers());
	}
	
	@RequestMapping("/login")
	public ModelAndView loginController(@ModelAttribute("customerlogin") Customers customer) {
		ModelAndView modelAndView=new ModelAndView();
		String uname=customer.getCustomerName();
		String pwd=customer.getCustomerPassword();
		
		String message=null;
//		if(customerService.getCustomer(uname, pwd)==false) {
//			message="Invalid Credentials";
//			modelAndView.addObject("message", message);
//			modelAndView.setViewName("loginFailed");
//		}
//		else {
//			modelAndView.addObject(message);
//		}
		if(customerService.getCustomer(uname,pwd) ==true) {
			message="Login Successful!";
			customerGlobal=customerService.getCustomerDetails(uname, pwd);
			modelAndView.addObject(message);
			modelAndView.setViewName("Welcome");
		}
		else {
			message="Login Failed";
			modelAndView.addObject(message);
			modelAndView.setViewName("loginFailed");
		}		
		return modelAndView;
	}
	
	
	@RequestMapping("/displayAllProds")
	public ModelAndView displayAllProductsPageController() {
		Collection<Products> products=productsService.getAllProdcuts();
		 return new ModelAndView("displayAllProducts","products",products);
	}
	
	@RequestMapping("/addToCart")
	public ModelAndView addToCart(@RequestParam("productId") int id,@RequestParam("productQuantity")int quantity) {
		Products product=productsService.buyProduct(id);
		ModelAndView modelAndView=new ModelAndView();
		
		String message;
		if(productsService.productAddtoCart(product, quantity)==1) {
			message="Product not found!";
			modelAndView.addObject("message",message);
			modelAndView.setViewName("cartFailure");
			return modelAndView;
		}
		else if(productsService.productAddtoCart(product, quantity)==2) {
			message="Please enter a proper qunatity between 1 and "+product.getProductQuantity();
			modelAndView.addObject("message",message);
			modelAndView.setViewName("cartFailure");
			return modelAndView;
		}
		else{
			int flagForSame=0;
			product.setProductQuantity(quantity);
			for(Products oldproduct:products) {
				if(oldproduct.getProductName().equals(product.getProductName())) {
					flagForSame=1;
					oldproduct.setProductQuantity(oldproduct.getProductQuantity()+product.getProductQuantity());
				}
			}
			if(flagForSame==0)
				products.add(product);
				return new ModelAndView("cartSuccess");
		}		
		
	}
	
	@RequestMapping("/cart")
	public ModelAndView cartController(){
		if(products.size()<1) {
			return new ModelAndView("emptycart");
		}
		return new ModelAndView("cart","products",products);
		
	}
	
	@RequestMapping("/removeproduct")
	public ModelAndView removeProductController() {
		return new ModelAndView("removefromcart","products",products);
	}
	@RequestMapping("/delete")
	public ModelAndView removeProductFromCart(@RequestParam("productId") int id,@RequestParam("productQuantity")int quantity) {
		ModelAndView modelAndView=new ModelAndView();
		String message;
		if(productsService.removeFromCart(id, quantity, products)==1) {
			message="Sorry no product found with id "+id+" in your cart";
			modelAndView.addObject("message",message);
			modelAndView.setViewName("removeFailure");
			return modelAndView;
		}
		else if(productsService.removeFromCart(id, quantity, products)==2) {
			message="Please enter valid quantity to remove";
			modelAndView.addObject("message",message);
			modelAndView.setViewName("removeFailure");
			return modelAndView;
		}
		else {
			Products removeProduct=null;
			int flagForZero=0;
			for(Products p:products) {
				if(p.getProductId()==id) {
					if(p.getProductQuantity()-quantity==0) {
						removeProduct=p;
						flagForZero=1;
					}
					else
						p.setProductQuantity(p.getProductQuantity()-quantity);
					break;
				}
			}
			if(flagForZero==1)
				products.remove(removeProduct);
		
			return new ModelAndView("removeSuccess");
		}
		
		
	}
	
	@RequestMapping("/checkout")
	public ModelAndView checkoutController() {
		ArrayList<Products> temp=products;
		Map<Double,ArrayList<Bill>> finalBill=transactionService.checkout(temp,customerGlobal.getCustomerId() );
		products.clear();
		return new ModelAndView("checkout","finalBill",finalBill);
	}
	
	@RequestMapping("/insertNewCustomer")
	public ModelAndView insertNewCustomerController() {
		return new ModelAndView("signUp", "customer", new Customers());		
	}
	@RequestMapping("/save")
	public ModelAndView insertNewCustomer(@ModelAttribute ("customer") Customers customer,BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("signUp","command",new Customers());
		}
		
		if(customerService.addNewCustomer(customer)) {
			return new ModelAndView("signuppass");
		}
		else {
			return new ModelAndView("signupFailure");
		}
	}
	
	@RequestMapping("/history")
	public ModelAndView getHistory() {
		//ArrayList<ArrayList<Transactions>> transactions=transactionService.getSeperateTransactions(customerGlobal.getCustomerId());
		ArrayList<Transactions> transactions=transactionService.getAllTransactions(customerGlobal.getCustomerId());
		return new ModelAndView("history","transactions",transactions);
	}
}
