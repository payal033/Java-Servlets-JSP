<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Coupon</title>
</head>
<body>
    <h2>Find Coupon</h2>
	<form method="post" action="coupons">
		<table>
			<tr>
				<td>Coupon Code</td>
				<td><input type="text" name="couponCode"></td>
			</tr>
			<td><input type="hidden" name="action" value="find"></td>
			<td><input type="submit" value="Find Coupon"></td>
		</table>
	</form>
</body>
</html>