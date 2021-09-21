<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Please Log in </h1>
<div align="center">
<spring:form action="./loginaction" method="post" modelAttribute="customer">
UserName <br> <spring:input path="customerName"/><br><br>
password <br> <spring:password path="customerPassword"/><br><br>
<input type="submit" value="Login">
</spring:form><br><br>
<a href="./">Go to main</a>
</div>
</body>
</html>