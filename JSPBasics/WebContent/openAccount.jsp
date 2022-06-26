<%@ page import="java.sql.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
%>
<%!Connection con;
	PreparedStatement pstmt;

	public void jspInit() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3305/mydb", "root", "admin");
			pstmt = con.prepareStatement("insert into account values (?, ?, ?, ?)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jspDestroy() {
		try {
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>
<%
int accno = Integer.parseInt(request.getParameter("accno"));
String fname = request.getParameter("firstname");
String lname = request.getParameter("lastname");
int balance = Integer.parseInt(request.getParameter("bal"));

try {
	pstmt.setInt(1, accno);
	pstmt.setString(2, lname);
	pstmt.setString(3, fname);
	pstmt.setInt(4, balance);

	int result = pstmt.executeUpdate();

} catch (Exception e) {
	e.printStackTrace();
}
%>

<%@ include file="openaccount.html" %>
