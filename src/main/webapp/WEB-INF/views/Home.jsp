<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include><br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form>
					<div>
						<a href="addaccount" button type="submit"
							class="btn btn-primary form-control">Please Add Account First</a>
					</div>
					<br>
					<br>
					<div>
						<a href="addcategory" button type="submit"
							class="btn btn-warning form-control">Please Add Category</a> <br>
						<br>
					</div>
					<br>
					<div>
						<a href="addprofile" button type="submit"
							class="btn btn-secondary form-control">Add Profile Picture</a> <br>
						<br>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>