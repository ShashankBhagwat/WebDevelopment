<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int number1=Integer.parseInt(request.getParameter("number1"));
int number2=Integer.parseInt(request.getParameter("number2"));
//out.println(number1+number2);
%>
Sum is : <%= number1+number2 %>
</body>
</html>