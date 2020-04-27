<%@page import="com.test.jsp.usebean.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="product" class="com.test.jsp.usebean.Product">
<jsp:setProperty property="*" name="product"/>
</jsp:useBean>

Product Details : <br>
ID : <jsp:getProperty property="id" name="product"/><br>
Name : <jsp:getProperty property="name" name="product"/><br>
Price : <jsp:getProperty property="price" name="product"/><br>
</body>
</html>