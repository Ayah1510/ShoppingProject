<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/styles.css">
<title>ShoppingCart</title>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="${ContextRoot}/">Back</a></li>
		</ul>
	</div>
	<div align="center">
		<h1>Shopping</h1>
		<table border="1" cellpadding="5">
			<tr>
				<th>UpoCode</th>
				<th>Items</th>
			</tr>
			<form:form action="${contextRoot}/shopping" method="post"
				modelAttribute="shoppingCart">
				<tr>
					<td><form:input path="shoppingNumber" placeholder="Enter the items" /></td>
					<td><select name="items" multiple="multiple">
								<c:forEach var="item" items="${items}">
									<option >${item.upoCode}</option>
								</c:forEach>
						</select></td>
				</tr>
				<form method="post">
					<button type="submit">Continue to Payment</button>
				</form>
				
			</form:form>
		</table>
	</div>
</body>
</html>