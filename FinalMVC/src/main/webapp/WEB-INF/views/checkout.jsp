<%@page import="java.util.ArrayList"%>
<%@page import="com.retail.bean.OrderItem"%>
<%@page import="com.retail.bean.OrderT"%>
<%@page import="java.util.List"%>
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
<h1>Your order has been placed successfully</h1>
<table border="1">
	<%OrderT o=(OrderT)request.getAttribute("o");
	double total=(double)request.getAttribute("total");%>
	<%List<OrderItem> items=(ArrayList<OrderItem>)o.getItems(); %>
	 <tr>
	 	<th>Product code</th>
	 	<th>Quantity</th>
	 	<th>Unit price</th>
	 </tr>
	 <%for(OrderItem i:items){ %>
	 <tr>
	 	<td><%=i.getProductId() %></td>
	 	<td><%=i.getQuantity() %></td>
	 	<td><%=i.getProductPrice() %></td>
	 </tr>
	 <%} %>
</table>
<h2>Total Bill amount:<%=total %></h2>
<br><br><br>
<h1>Thanks for shopping with us ${customer.customerName}!</h1><br><br><br>
<a href="./loginaction">Go back to home</a>
</body>
</html>