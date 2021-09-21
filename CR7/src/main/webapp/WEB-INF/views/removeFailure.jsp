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
<h1>Oops! Couldn't remove product!!</h1>
<% String message = (String)request.getAttribute("message"); %>
${message }
<br><br><br><br>
<a href="./removeproduct">Go back to remove</a><br>
<a href="./cart">Go to cart</a>
</body>
</html>