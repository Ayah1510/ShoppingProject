<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/styles.css">
<title>CreditCard</title>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="${ContextRoot}/">Back</a></li>
		</ul>
	</div>
	<div align="center">
		<h1>Registration for CreditCard</h1>
		<table border="1" cellpadding="5">
			<tr>
				<th>Card Number</th>
				<th>Name</th>
				<th>CVV</th>
				<th>Date Of Expiration</th>
				<th>Balance</th>
			</tr>
			<form:form action="${contextRoot}/creditcard" method="post"
				modelAttribute="creditcard">
				<tr>
					<td><form:input path="cardNumber"
							placeholder="Enter the creditcard number" /></td>
					<td><form:input path="name" placeholder="Enter the name" /></td>
					<td><form:input path="cvv" placeholder="Enter the cvv" /></td>
					<td><form:input path="dateOfExpiry" placeholder="Enter the date(mm/yy)" /></td>
					<td><form:input path="balance" placeholder="Enter the balance" /></td>
				</tr>
				<form method="post">
					<button type="submit">Submit</button>
				</form>
			</form:form>

		</table>
	</div>
</body>
</html>