package com.trainings.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainings.project.daos.CouponDAO;
import com.trainings.project.model.Coupon;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CouponDAO dao = new CouponDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("create")) {
			createCoupon(request, response);
		} else if (action.equals("find")) {
			findByCoupon(request, response);
		}
	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String code = request.getParameter("couponCode");
		int discount = Integer.parseInt(request.getParameter("discount"));
		String exp_date = request.getParameter("expiryDate");

		Coupon coupon = new Coupon();
		coupon.setCouponCode(code);
		coupon.setDiscount(discount);
		coupon.setExpiryDate(exp_date);

		dao.saveCoupon(coupon);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h2>Coupon Created</h2>");
		out.print("<div><a href='/FinalProject'>Home</a></div>");

	}

	private void findByCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("couponCode");
		Coupon c = dao.findByCouponCode(code);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h2>Coupon Details</h2>");
		out.print(c.toString());

	}

}
