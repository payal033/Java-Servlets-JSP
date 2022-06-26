<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition</title>
</head>
<body>

<%
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));
%>

<h2>Sum of <%=num1 %> & <%=num2 %> is <%= num1 + num2 %></h2>

</body>
</html>