<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href='<c:url value="/styles/mystyle.css"></c:url>'>
<style type="text/css">h1{text-align: center;}</style>
<title>Login Failed</title>
</head>
<body>
<h1>OOPS! Login in failed!! Please Enter correct credentials!!!</h1>

<h2>${message }</h2>

<div align="center">
<a href="./l">Go Back to Log in page</a><br>
<a href="./">Go Back to Main Page</a>
</div>
</body>
</html>