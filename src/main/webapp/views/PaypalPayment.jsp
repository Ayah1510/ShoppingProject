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
<title>PayPalPayment</title>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="${ContextRoot}/">Back</a></li>
		</ul>
	</div>
	<div align="center">
		<h1>PayPal Payment</h1>

		<form:form action="${contextRoot}/payment/paypal/result" method="post"
			modelAttribute="paypalstrategy">
			<label>Email</label>
			<form:input path="emailId" placeholder="Email" />
			<label>Password</label>
			<form:input path="password" placeholder="Password" />
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