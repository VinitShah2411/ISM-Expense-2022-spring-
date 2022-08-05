<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
<s:form action="savecateogry" method="post" modelAttribute="category">
		Add Category <s:input path="category_name" /><br> <br>
		<input type="submit" value="Add">
	</s:form>
</body>
</html>