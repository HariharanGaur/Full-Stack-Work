<%@page import="com.retail.bean.OrderItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Collection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Your cart</h1>
<table border="1">
	<tr>
		<th>Product Code</th>
		<th>Quantity</th>
	</tr>
	<%ArrayList<OrderItem> items=(ArrayList<OrderItem>)request.getAttribute("items"); %>
	<%for(OrderItem i:items){ %>
	<tr>
		<td><%=i.getProductId() %></td>
		<td><%=i.getQuantity() %></td>
	</tr>
	<%} %>
</table>
<br><br><br>
<a href="./products">Go back to add more products</a><br>
<a href="./checkout">Go to checkout</a><br>
<a href="./loginaction">Go To Main Page</a>
</body>
</html>