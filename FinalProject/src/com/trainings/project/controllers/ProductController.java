package com.trainings.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainings.project.daos.CouponDAO;
import com.trainings.project.daos.ProductDAO;
import com.trainings.project.model.Coupon;
import com.trainings.project.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO pdao = new ProductDAO();
	CouponDAO cdao = new CouponDAO();
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name  = request.getParameter("productName");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		String couponCode = request.getParameter("couponCode");

		Product product = new Product();
	
		Coupon c = cdao.findByCouponCode(couponCode);
		
		System.out.println(c.getDiscount());
		double discountPrice = (c.getDiscount() / 100) * price;
		System.out.println(c.getDiscount() / 100);
		double finalPrice = price - discountPrice;
		System.out.println(finalPrice);
		
		product.setProductName(name);
		product.setDescription(description);
		product.setPrice(finalPrice);
		
		pdao.saveProduct(product);
			
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h2>Product Created!</h2>");
		out.print(product.toString());
		out.print("<div>Coupon code: " + couponCode + "</div>");
		out.print("<div>Discount %: " + c.getDiscount() + "</div> <br/>");
		out.print("<div><a href='/FinalProject'>Home</a></div>");
	}

}