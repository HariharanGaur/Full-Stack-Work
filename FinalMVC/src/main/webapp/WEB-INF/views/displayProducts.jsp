<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Collection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>   
<%@page import="com.retail.bean.Products"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Products List</h1>
<table border="1">
	<tr>
		<th>Product code</th>
		<th>Product Name</th>
		<th>Description</th>
		<th>Unit Price</th>
	</tr>
	<%List<Products> products=(List<Products>)request.getAttribute("products"); %>
	<%for(Products product:products){ %>
	<tr>
		<td><%=product.getCode() %></td>
		<td><%=product.getName() %></td>
		<td><%=product.getDescription() %></td>
		<td><%=product.getPrice() %></td>
	</tr>
	<%} %>
</table>
<br><br>
<spring:form action="./addToCart">
Product Code<br><input type="text" name="productCode"/><br>
Product Quantity<br><input type="number" name="productQuantity"/><br><br>
<input type="submit" value="Add">
</spring:form>		
<br><br>
<a href="./loginaction">Go To Main Page</a>
</body>
</html>