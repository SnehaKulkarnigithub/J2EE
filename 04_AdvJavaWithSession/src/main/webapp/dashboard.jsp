<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<%@ include file="header.jsp" %>
</head>
<body>
<h1>Welcome to Dashboard</h1>
<%
out.println("UserIdInSession  "+useridheder);
out.println("UserEmailInSession  "+useremailheder);
%>
</body>
</html>
