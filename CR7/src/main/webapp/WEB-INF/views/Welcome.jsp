<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href='<c:url value="/styles/mystyle.css"></c:url>'>
<title>Insert title here</title>
</head>
<body bgcolor="lightgray" >
<h1 align="center">Hello ${customerlogin.customerName} ! What do you want to do today?</h1>
<div align="center">
<a href="./displayAllProds">Buy Products</a><br><br>
<a href="./cart">Check your cart</a><br><br>
<a href="./history">View Order History</a>
</div>
</body>
</html>