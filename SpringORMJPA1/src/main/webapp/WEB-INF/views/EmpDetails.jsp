<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Details</h1>
	<table border="1" width="50%">
		<tr>
			<th>PS Number</th>
			<td>${requestScope.emp.empId }</td>
		</tr>
		<tr>
			<th>First Name</th>
			<td>${requestScope.emp.firstName }</td>
		</tr>
		<tr>
			<th>Last Name</th>
			<td>${requestScope.emp.lastName }</td>
		</tr>
		<tr>
			<th>Email</th>
			<td>${requestScope.emp.email }</td>
		</tr>
	</table>
</body>
</html>