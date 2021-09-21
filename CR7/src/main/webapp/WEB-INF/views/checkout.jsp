<%@page import="com.cr7.bean.Products"%>
<%@page import="com.cr7.bean.Customers"%>
<%@page import="com.cr7.bean.Bill"%>
<%@page import="java.util.*"%>
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
<h1>Your Final Bill</h1>
<table border="1" >
	<tr>
		<td>S.No</td>
		<td>Product Name</td>
		<td>Quantity</td>
		<td>Unit Price</td>
		<td>Tax</td>
		<td>Amount</td>
	</tr>
	<% Map<Double,ArrayList<Bill>> finalBill=(Map<Double,ArrayList<Bill>>)request.getAttribute("finalBill"); %>
	<% Map.Entry<Double,ArrayList<Bill>> entry = finalBill.entrySet().iterator().next();
		double key = entry.getKey();
	 	ArrayList<Bill> value = entry.getValue();  %>
	<%for(Bill b:value){ %>
	<tr>
		<td><%=b.getsNo() %></td>
		<td><%=b.getProductName() %></td>
		<td><%=b.getProductQuantity() %></td>
		<td><%=b.getUnitPrice() %></td>
		<td><%=b.getTax() %></td>
		<td><%=b.getPrice() %></td>
	</tr>
	<%} %>
</table>
<br><br>
<h1>Thank you for shopping with us</h1><br><br>
<a href="./login">Go to home page</a>
</body>
</html>