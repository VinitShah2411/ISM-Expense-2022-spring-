<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>

</head>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>
	<br>
	<br>

	<s:form action="saveaccount" method="post" modelAttribute="account">
		Account type: <s:select path="account_type">
			<option disabled="disabled" selected="selected">--Select
				type--</option>
			<s:option value="cash">Cash</s:option>
			<s:option value="paytm">Paytm</s:option>
			<s:option value="creditcard">Credit Card</s:option>
			<s:option value="debitcard">Debit Card</s:option>
		
		</s:select><br><br>
		<div id="account_balance">
			Account Balance:
			<s:input path="account_balance" />
			<s:errors path="account_balance" cssStyle="color:red"></s:errors>
		<br> <br>
		</div>
		<div id="card_number">
			Card Number:
			<s:input path="card_number" />
			<s:errors path="card_number" cssStyle="color:red"></s:errors>
		<br><br>
		</div>
		<div id="upi_id">
			UPI Id:
			<s:input path="upi_id" />
			<s:errors path="upi_id" cssStyle="color:red"></s:errors>
		<br> <br>
		</div>
		<button type="submit">Add Account</button>
		<s:hidden path="userId" />
	</s:form>
	
	<script type="text/javascript">
	document.addEventListener('DOMContentLoaded',function(){
        document.querySelector("#account_type").onchange=function()
        {
	        if(this.value == "cash"){
	            document.querySelector("#account_balance").style.display='block';
	            document.querySelector("#card_number").style.display='none';
	    		document.querySelector("#upi_id").style.display='none';
	    	}
	    	if(this.value == "paytm"){
	    		document.querySelector("#upi_id").style.display='block';
	            document.querySelector("#card_number").style.display='none';
	            document.querySelector("#account_balance").style.display='block';
	    	}
        	if(this.value=='creditcard' ||this.value == 'debitcard'){
                document.querySelector("#account_balance").style.display='block';	
                document.querySelector("#card_number").style.display='block';
        		document.querySelector("#upi_id").style.display='none';
        	}
        }
})
    	</script>
</body>
</html>