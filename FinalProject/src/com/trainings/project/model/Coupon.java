package com.trainings.project.model;

import java.util.Date;

public class Coupon {

	private int id;
	private String couponCode;
	private int discount;
	private String expiryDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "<div>Coupon Id: " + id + "</div><div>Coupon Code: " + couponCode + "</div><div>Discount: " + discount + "%</div><div>Expiry Date: "
				+ expiryDate + "</div>";
	}

}
