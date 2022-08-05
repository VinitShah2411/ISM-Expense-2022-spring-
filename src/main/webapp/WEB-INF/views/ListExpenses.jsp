<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Expenses</title>
</head>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>
	<br>
	<br>
	<table border="1">
		<tr>
			<th>Expense Name</th>
			<th>Expense Description</th>
			<th>Expanse Amount</th>
			<th>Expanse Payment Mode</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${expenses}" var="e">
			<tr>
				<td><center>${e.expense_name}</center></td>
				<td><center>${e.expense_description}</center></td>
				<td><center>${e.expense_amount}</center></td>
				<td><center>${e.expense_paymentmode}</center></td>
				<td>
				<a href="editexpense?expenseId=${e.expenseId}">Edit</a>
				|<a href="deleteexpense?expenseId=${e.expenseId}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>