<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SubCategory</title>
</head>
<body>
<s:form action="savesubcateogry" method="post" modelAttribute="subcategory" >
	Expense Category:<s:select path="category_id">
		<c:forEach items="${category}" var="cat">
			<s:option value="${cat.category_id}">${cat.category_name}</s:option>
		</c:forEach>
	</s:select>
	<br>
	<br>
	sub category <s:input path="subcategory_name"/>
	<input type="submit" value="Add">
	<!-- <input type="hidden" value="" name="category_id"> <br><br> -->
	</s:form>
</body>
</html>