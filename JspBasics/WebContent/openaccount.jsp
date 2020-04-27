<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%! 
Connection conn;
Statement st;
%>

<% 
Class.forName("com.mysql.cj.jdbc.Driver");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
st=conn.createStatement();
String accno=request.getParameter("accno");
String lastname=request.getParameter("lastname");
String firstname=request.getParameter("firstname");
String bal=request.getParameter("bal");
st.executeUpdate("insert into account values('"+accno+"','"+lastname+"','"+firstname+"','"+bal+"')");
%>

<%@ include file="openaccount.html" %>
</body>
</html>