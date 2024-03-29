package com.trainings.project.model;

import java.math.BigDecimal;

public class Product {

	private int productId;
	private String productName;
	private String description;
	private double price;
	private String couponCode;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double f) {
		this.price = f;
	}

	@Override
	public String toString() {
		return "</div><div> Product Name: " + productName + "</div><div>Description: " + description
				+ "</div><div>Price: " + price + "</div><div>";
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}



}
