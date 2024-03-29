package com.trainings.project.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trainings.project.model.Coupon;
import com.trainings.project.util.ConnectionUtil;

public class CouponDAO {

	public void saveCoupon(Coupon coupon) {
		Connection con = ConnectionUtil.getConnection();
		String query = "insert into coupon(code, discount, expiryDate) values (?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, coupon.getCouponCode());
			stmt.setInt(2, coupon.getDiscount());
			stmt.setString(3, coupon.getExpiryDate());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Coupon findByCouponCode(String code) {
		Coupon coupon = new Coupon();
		Connection con = ConnectionUtil.getConnection();
		String query = "select * from coupon where code= ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, code);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				coupon.setId(result.getInt(1));
				coupon.setCouponCode(result.getString(2));
				coupon.setDiscount(result.getInt(3));
				coupon.setExpiryDate(result.getString(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return coupon;
		
	}

}
