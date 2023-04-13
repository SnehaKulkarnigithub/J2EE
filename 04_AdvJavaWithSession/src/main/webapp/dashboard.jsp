<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<h1>Welcome to Dashboard</h1>
	
</body>
Welcome,<%=useremailheder%>
<sql:query var="result" dataSource="${webappDataSource}">
	SELECT * FROM user.registeruser WHERE email="<%=useremailheder%>" ;
</sql:query>
<table border="1">
	<tbody>
		<tr>
			<th>userId</th>
			<th>firstName</th>
			<th>middelName</th>
			<th>lastName</th>
			<th>email</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td>${row.userId}</td>
				<td>${row.fname}</td>
				<td>${row.mname}</td>
				<td>${row.lname}</td>
				<td>${row.email}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</html>
