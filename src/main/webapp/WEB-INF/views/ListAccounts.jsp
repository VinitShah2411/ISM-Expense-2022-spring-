<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List All Accounts</title>

</head>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>
	<br>
	<br> Account type:
	<select id="account_type">
		<option disabled="disabled" selected="selected">--Select
			type--</option>
		<option value="id_paytm">Paytm</option>
		<option value="cash1">Cash</option>
		<option value="card1">Card</option>
	</select>
	<br> <br>
	
	<div id="paytm">
	<table border="1">
		<thead>
			<tr>
				<th>Account Type</th>
				<th>Account Balance</th>
				<th>UPI Id</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${account1}" var="acc">
				<tr>
					<td>${acc.account_type}</td>
					<td>${acc.account_balance}</td>
					<td>${acc.upi_id }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
		<br> 
	
	<div id="cash1">
	<table  border="1">
		<tr >
			<td>Account Type</td>
			<td>Account Balance</td>
		</tr>
		<c:forEach items="${account2 }" var="acc1">
			<tr>
				<td>${acc1.account_type}</td>
				<td>${acc1.account_balance}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<br>
	
	<div id="card1"> 
	<table  border="1">
		<tr >
			<td>Account Type</td>
			<td>Account Balance</td>
			<td>Card Number</td>
		</tr>
		<c:forEach items="${account3 }" var="acc3">
			<tr >
				<td>${acc3.account_type}</td>
				<td>${acc3.account_balance}</td>
				<td>${acc3.card_number}</td>
			</tr>
		</c:forEach>
	</table>
	</div>

	<script type="text/javascript">
	/* document.querySelector("#cash1").style.display = 'none';
	document.querySelector("#card1").style.display = 'none';
	document.querySelector("#paytm").style.display = 'none'; */
		document.addEventListener('DOMContentLoaded', function() {
			document.querySelector("#account_type").onchange = function() {
				if (this.value == "cash1") {
					document.querySelector("#cash1").style.display = 'block';
					document.querySelector("#card1").style.display = 'none';
					document.querySelector("#paytm").style.display = 'none';
					/* document.querySelector("#cash2").style.display = 'block';
					document.querySelector("#card2").style.display = 'none';
					document.querySelector("#paytm2").style.display = 'none'; */
				}
				if (this.value == "id_paytm") {
					document.querySelector("#paytm").style.display = 'block';
					document.querySelector("#card1").style.display = 'none';
					document.querySelector("#cash1").style.display = 'none';
				/* 	document.querySelector("#cash2").style.display = 'none';
					document.querySelector("#card2").style.display = 'none';
					document.querySelector("#paytm2").style.display = 'block'; */
				}
				if (this.value == 'card1' || this.value == 'debitcard') {
					document.querySelector("#cash1").style.display = 'none';
					document.querySelector("#card1").style.display = 'block';
					document.querySelector("#paytm").style.display = 'none';
					/* document.querySelector("#cash2").style.display = 'none';
					document.querySelector("#card2").style.display = 'block';
					document.querySelector("#paytm2").style.display = 'none'; */
				}
			}
		})
	</script>

</body>
</html>