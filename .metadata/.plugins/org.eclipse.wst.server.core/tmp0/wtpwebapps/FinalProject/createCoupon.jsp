<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Coupon</title>
</head>
<body>
	<h2>Create Coupon</h2>
	<form method="post" action="coupons">
		<table>
			<tr>
				<td>Coupon Code</td>
				<td><input type="text" name="couponCode"></td>
			</tr>
			<tr>
				<td>Discount %</td>
				<td><input type="text" name="discount"></td>
			</tr>
			<tr>
				<td>Expiry Date</td>
				<td><input type="date" name="expiryDate"></td>
			</tr>
			<td><input type="hidden" name="action" value="create"></td>
			<td><input type="submit" value="Save Coupon"></td>
		</table>
	</form>
</body>
</html>