<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/styles.css">
<title>Accounts</title>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="${ContextRoot}/">Back</a></li>
		</ul>
	</div>
	<div align="center">
		<h1>List of Accounts</h1>
		<h2>PayPal Accounts</h2>
		<table border="1" cellpadding="5">
			<tr>
				<th>Email</th>
				<th>Password</th>
				<th>Balance</th>
			</tr>
			<c:forEach var="paypal" items="${paypals}">
				<tr>
					<td><c:out value="${paypal.emailId}" /></td>
					<td><c:out value="${paypal.password}" /></td>
					<td><c:out value="${paypal.balance}" /></td>
				</tr>
			</c:forEach>
		</table>
		
		<h2>CreditCard Accounts</h2>
		<table border="1" cellpadding="5">
			<tr>
				<th>Card Number</th>
				<th>Name</th>
				<th>CVV</th>
				<th>Date Of Expiration</th>
				<th>Balance</th>
			</tr>
			<c:forEach var="creditcard" items="${creditcards}">
				<tr>
					<td><c:out value="${creditcard.cardNumber}" /></td>
					<td><c:out value="${creditcard.name}" /></td>
					<td><c:out value="${creditcard.cvv}" /></td>
					<td><c:out value="${creditcard.dateOfExpiry}" /></td>
					<td><c:out value="${creditcard.balance}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>