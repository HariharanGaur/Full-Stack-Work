<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href='<c:url value="/styles/mystyle.css"></c:url>'> 
<title>Insert title here</title>
</head>
<body>
<h1>Please kindly register with the details!</h1><br><br><br>
<div class=container>
<div class="options">
	<spring:form action="./save" method="post" modelAttribute="customer">
		Name <br><spring:input path="customerName"/><br>
		Password <br><spring:password path="customerPassword"/><br>
		Address <br><spring:input path="customerAddress"/><br>
		Phone number<br><spring:input path="customerNumber"/><br><br>
		<input type="submit" value="Sign Up">
	</spring:form>
</div>
</div>
</body>
</html>