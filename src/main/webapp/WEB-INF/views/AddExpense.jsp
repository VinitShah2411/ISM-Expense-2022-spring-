<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Expense</title>
</head>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>
	<s:form action="addexpense" method="post" modelAttribute="expense">
		<br>
		<br>
 	 Expense Name:<s:input type="text" path="expense_name"
			placeholder="Expense Name" />
			<s:errors path="expense_name" cssStyle="color:red"></s:errors>
		<br>
		<br>
	 Expense Description:<s:input type="text" path="expense_description" placeholder="Expance Description" />
	 <s:errors path="expense_description" cssStyle="color:red"></s:errors>
		<br>
		<br>
	Expense	Category:<s:select path="categoryId" id="category">
				 	<s:option value="">select ..</s:option>
				 <c:forEach items="${category}" var="cat">
				 	<s:option value="${cat.category_id}">${cat.category_name}</s:option>
				 </c:forEach>
		</s:select>
		<br>
		<br>
		
		Sub	Category:<s:select path="subcategoryId" id="subCategory">
				<s:option value="">select ..</s:option>
		</s:select>	<br><br>	 
	 Expense Amount:<s:input type="text" path="expense_amount" placeholder="Expance Amount" />
	 <s:errors path="expense_amount" cssStyle="color:red"></s:errors>
		<br>
		<br>
	 Expense Date:<s:input type="date" path="expense_date" />
	 <s:errors path="expense_date" cssStyle="color:red"></s:errors>
		<br>
		<br>
	 Expense Time:<s:input type="time" path="expense_time" />
	 <s:errors path="expense_time" cssStyle="color:red"></s:errors>
		<br>
		<br>
	 Expense PaymentMode:<s:select path="expense_paymentmode">
			<s:errors path="expense_paymentmode"></s:errors>
			<c:forEach items="${A1}" var="acc">
				<s:option value="${acc.account_id}">${acc.account_type}</s:option>
			</c:forEach>
			<c:forEach items="${A2}" var="acc">
				<s:option value="${acc.account_id}">${acc.account_type}</s:option>
			</c:forEach>
			<c:forEach items="${A3}" var="acc">
				<s:option value="${acc.account_id}">${acc.account_type}</s:option>
			</c:forEach>
			<%-- <s:option value="cash">Cash</s:option>
			<s:option value="paytm">Paytm</s:option>
			<s:option value="creditcard">Credit Card</s:option>
			<s:option value="debitcard">Debit Card</s:option> --%>
		</s:select>
		<br>
		<br>
		<button type="submit">Add Expense</button>
	</s:form>
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
	<script>
	
		$(document).ready(function(){
			$("#category").change(function(){
			var id = document.getElementById("category").value;
						let url = "http://localhost:9898/subcategory?category_id="+id;	
						 	 
						$.get(url)
						.done(function(data){
							console.log("gj"+data);
							let subcategory = $("#subCategory");
							subcategory.empty() 
								for(let i=0;i<data.length;i++){ 
									subcategory.append(`<option value=`+data[i].subcategoryid+`>`+data[i].subcategory_name+`</option>`);
							}
							
						}).fail(function(){
							console.log("something went wrong"); 
						});
			})	
		})
		
		
	</script>

</body>
</html>





