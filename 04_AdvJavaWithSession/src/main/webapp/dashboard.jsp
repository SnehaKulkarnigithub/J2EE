<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<%@ include file="header.jsp"%>
</head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
<link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="dist/css/adminlte.min.css">
<body>
	<h1>Welcome to Dashboard</h1>
</body>
<sql:query var="result" dataSource="${webappDataSource}">
	SELECT * FROM user.registeruser WHERE email="<%=useremailheder%>" ;
</sql:query>
<div class="card">
	<div class="card-header">
		<h3 class="card-title">
			Welcome,<%=useremailheder%></h3>
	</div>
	<!-- /.card-header -->
	<div class="card-body">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Middel Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${result.rows}">
					<tr>
						<td>${row.fname}</td>
						<td>${row.mname}</td>
						<td>${row.lname}</td>
						<td>${row.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.card-body -->
</div>
</html>
