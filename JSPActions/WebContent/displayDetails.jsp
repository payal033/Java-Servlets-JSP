<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<jsp:useBean id="product" class="com.trainings.jsp.Product">
		<jsp:setProperty name="product" property="*" />
	</jsp:useBean>
	<h1>Product Details</h1>
	<p>
		Product Id:
		<jsp:getProperty name="product" property="id" /></p>
	<p>
		Product Name:
		<jsp:getProperty name="product" property="name" /></p>
	<p>
		Description:
		<jsp:getProperty name="product" property="description" /></p>
	<p>
		Product Price:
		<jsp:getProperty name="product" property="price" /></p>
</body>
</html>