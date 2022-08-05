<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
</head>
<body>

	<s:form action="saveuser" method="post" modelAttribute="user">
	
		FirstName: <s:input path="firstName" />
		<s:errors path="firstName" cssStyle="color:red"></s:errors>
		<br>
		<br>
		LastName: <s:input path="lastName" />
		<s:errors path="lastName" cssStyle="color:red"></s:errors>
		<br>
		<br>
		Email: <s:input path="email" />
		<s:errors path="email" cssStyle="color:red"></s:errors>
		<br>
		<br>
		Password: <s:input path="password" />
		<s:errors path="password" cssStyle="color:red"></s:errors>
		<br>
		<br>
		<input type="submit" value="Signup" />
	</s:form>
</body>
</html>