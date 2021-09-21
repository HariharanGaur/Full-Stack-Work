<%@page import="com.cr7.bean.Products"%>
<%@page import="com.cr7.bean.Customers"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href='<c:url value="/styles/mystyle.css"></c:url>'>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome ${customerlogin.customerName}!</h2>
<h1>Your Cart</h1>
<table border="1">
	<tr>
		<td>Product Id</td>
		<td>Product Name</td>
		<td>Price</td>
		<td>Available Quantity</td>
	</tr>
	<% Collection<Products> products=(Collection<Products>)request.getAttribute("products");
	for(Products product:products){
	%>
	<tr>
		<td><%=product.getProductId() %></td>
		<td><% out.println(product.getProductName()); %></td>
		<td><%=product.getProductPrice() %></td>
		<td><%=product.getProductQuantity() %></td>
	</tr>
	<% } %>
</table>
<a href="./checkout">Checkout</a><br>
<a href="./displayAllProds">Go back to add more products</a><br>
<a href="./removeproduct">Remove Product</a><br>
<a href="./login">Go to Home page</a><br>
</body>
</html>