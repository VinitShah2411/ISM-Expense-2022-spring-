<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<s:form action="login" method="post" modelAttribute="login">
	Email:<s:input path="email" />
		<s:errors path="email" cssStyle="color:red"></s:errors>
		<br>
		<br>
	Password:<s:input path="password" />
		<s:errors path="password" cssStyle="color:red"></s:errors>
		<br>
		<br>
		<input type="submit" value="Login">
		${msg}
	</s:form>
</body>
</html>