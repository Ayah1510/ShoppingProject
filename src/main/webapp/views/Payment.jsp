<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://yui.yahooapis.com/3.5.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" href="/css/styles.css">
<style>
.container {
  /* Layout stuff unrelated to demo */
  padding: 7rem;
  text-align: center;
  width: 100%;
}


body {
  margin: 0;
  padding: 0;
  font-size: 1.2rem;
  display: flex;
  flex-wrap: wrap;
  min-height: 100vh;
  font-family: sans-serif;
}
h1{
	padding: 5rem  4rem;
	font-size: 28px;
}
a {
  padding: 2rem 4rem;
  border: 0.2rem solid  #05847A;
  border-radius: 0.5rem;
  color: white;
  /* match default body styles */
  font-size: inherit;
  background-color: #05847A;
}


</style>
<title>Insert title here</title>
</head>

<body>
<div class="container">

	<h1>Select Payment Option</h1>

	<a href="${ContextRoot}/payment/creditcard">Credit Card</a>
	<a href="${ContextRoot}/payment/paypal">PayPal</a>

</div>


</body>
</html>