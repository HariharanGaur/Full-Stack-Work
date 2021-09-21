<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<br><br><br><br>
<a href="./cart">Go to cart</a><br>
<a href="./displayAllProds">Go back to add more products</a><br>
<a href="./login">Go to Home page</a><br>
</body>
</html>