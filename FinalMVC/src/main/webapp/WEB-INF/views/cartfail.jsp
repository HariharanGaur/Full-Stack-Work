<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Oops! Couldn't add product!!</h1>
<% String message = (String)request.getAttribute("message"); %>
${message }
<br><br><br>
<a href="./products">Go back to add more products</a><br>
<a href="./cart">Go to cart</a><br>
<a href="./loginaction">Go To Main Page</a>
</body>
</html>