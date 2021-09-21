<%@page import="com.cr7.bean.Transactions"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href='<c:url value="/styles/mystyle.css"></c:url>'>
<title>Insert title here</title>
</head>
<body>
<h1>Your order history!!!</h1>
	<table border="1" >
	<tr>
		<td>Product Id</td>
		<td>Product Name</td>
		<td>Quantity</td>
	</tr>
	<% ArrayList<Transactions> tlist=(ArrayList<Transactions>)request.getAttribute("transactions");%>
	<%for(Transactions t:tlist){ %>
		<tr>
			<td><%=t.getProductId() %></td>
			<td><%=t.getProductName() %></td>
			<td><%=t.getProductQuantity() %></td>
		</tr>
	<%} %>
	</table><br><br>

<br><br>
<a href="./login">Go back to home page</a>
</body>
</html>