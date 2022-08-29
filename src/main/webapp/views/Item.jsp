<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/styles.css">
<title>Items</title>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="${ContextRoot}/">Back</a></li>
		</ul>
	</div>
	<div align="center">
		<h1>List of Items</h1>
		<table border="1" cellpadding="5">
			<tr>
				<th>UpoCode</th>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach var="item" items="${items}">
				<tr>
					<td><c:out value="${item.upoCode}" /></td>
					<td><c:out value="${item.name}" /></td>
					<td><c:out value="${item.price}" /></td>
					<td><form method="post">
							<a href="${ContextRoot}/item/${item.upoCode}">Edit</a>
						</form></td>
					<td><form action="${ContextRoot}/item/delete/${item.upoCode}" method="post">
							<a href="${ContextRoot}/item/delete/${item.upoCode}">Delete</a>
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<button>
		<form method="post">
			<a href="${contextRoot}/item/insertion/">Add New Item</a>
		</form>
	</button>
</body>
</html>