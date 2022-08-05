<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Categories</title>
</head>
<style>
body {
	counter-reset: Serial;
}

tr td:first-child:before {
	counter-increment: Serial;
	content: counter(Serial);
}
</style>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>
	<h2>View Category</h2>
	<br>
	<table border="1">
		<tr>
			<th>Sr No</th>
			<th>Category</th>
			<th>Sub Category</th>
			<!-- <th>User Id</th> -->
			<c:forEach items="${categories}" var="c">
				<tr>
					<td></td>
					<td>${c.category_name}</td>
					<td>${c.subcategory_name}</td>
					<%-- <a href="addsubcategory?category_id=${SubCategoryBean.category_id }">Add Sub Category</a> --%>
					<%-- <td>${c.userId}</td> --%>
				</tr>
			</c:forEach>
	</table>
</body>
</html>