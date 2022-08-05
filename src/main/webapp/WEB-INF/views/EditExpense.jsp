<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
</head>
<body>
<jsp:include page="UserMenu.jsp"></jsp:include>
<br>
	<br>
<s:form action="updateexpense" method="post" modelAttribute="expense">
		<br>
		<br>
 	 Expense Name:<s:input type="text" path="expense_name"/>
		<br>
		<br>
	 Expence Description:<s:input type="text" path="expense_description"/>
		<br>
		<br>
	 Expence Amount:<s:input type="text" path="expense_amount"/>
		<br>
		<br>
	 Expence Date:<s:input type="date" path="expense_date" />
		<br>
		<br>
	 Expence Time:<s:input type="time" path="expense_time" />
		<br>
		<br>
	 Expence Paymentmode:<s:select path="expense_paymentmode">
			<s:option value="Please Select"></s:option>
			<s:option value="cash">Cash</s:option>
			<s:option value="paytm">Paytm</s:option>
			<s:option value="creditcard">Credit Card</s:option>
			<s:option value="debitcard">Debit Card</s:option>
		</s:select>
		<br>
		<br>
		<s:hidden path="expenseId" />
		<input type="submit" value="Update" />
	</s:form>
</body>
</html>