<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MainPage</title>
<link rel="stylesheet" href='<c:url value="/styles/mystyle.css"></c:url>'>
</head>

<body bgcolor="teal">
<div class="container">
<div class="options" align="center">
<spring:form action="./login" method="post" modelAttribute="customerlogin">
UserName <br> <spring:input path="customerName"/><br><br>
password <br> <spring:password path="customerPassword"/><br><br>
<input type="submit" value="Login">
</spring:form><br><br>
<a href="./">Go to main page</a>
</div>
</div>
</body>
</html>