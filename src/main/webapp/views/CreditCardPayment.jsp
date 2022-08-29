<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/styles.css">
<title>CreditCardPayment</title>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="${ContextRoot}/">Back</a></li>
		</ul>
	</div>
	<div align="center">
		<h1>Credit Card Payment</h1>

		<form:form action="${contextRoot}/payment/creditcard/result"
			method="post" modelAttribute="creditcardstrategy">
			<label>Card Number</label>
			<form:input path="cardNumber" placeholder="Card Number" />
			<label>Name</label>
			<form:input path="name" placeholder="Name" />
			<label>CVV</label>
			<form:input path="cvv" placeholder="CVV" />
			<label>Date Of Expiration</label>
			<form:input path="dateOfExpiry" placeholder="Date Of Expiry" />
			<label>ShoppingCart Number</label>
			<select name="cart">
				<c:forEach var="cart" items="${carts}">
					<option>${cart.shoppingNumber}</option>
				</c:forEach>
			</select>
			<form method="post">
				<button type="submit">Submit</button>
			</form>
		</form:form>

	</div>

</body>
</html>