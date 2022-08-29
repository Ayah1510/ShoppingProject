<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/styles.css">
<title>Item Edit</title>
<style type="text/css">
#test {
	
}
</style>
</head>
<body>

	<div align="center">
		<table border="1" cellpadding="5">

			<tr>
				<th>UpoCode</th>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<form:form action="${contextRoot}/item" method="post"
				modelAttribute="item">
				<tr>
					<td><form:input path="upoCode"/></td>
					<td><form:input path="name"
							placeholder="Enter the item's name" /></td>
					<td><form:input path="price"
							placeholder="Enter the price" /></td>
				</tr>
				<form method="post">
				<button type="submit">Submit</button>
				</form>
			</form:form>

		</table>
	</div>



</body>

</html>
