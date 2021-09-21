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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href='<c:url value="/styles/mystyle.css"></c:url>'>
</head>
<body bgcolor="lightgray">
<h2>Welcome ${customerlogin.customerName}!</h2>
<h1>Product List</h1>
<%-- 
<% out.println("Displaying message with scriptlets"); %>
<%="displaying message with expression tag" %>
--%>
<table class="table"border="1">
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
<br><br>
<spring:form action="./addToCart">
Product Id<br><input type="number" name="productId"/><br>
Product Quantity<br><input type="number" name="productQuantity"/><br><br>
<input type="submit" value="Add">
</spring:form>		
<br><br>
<a href="./login">Go To Main Page</a>
</body>
</html>