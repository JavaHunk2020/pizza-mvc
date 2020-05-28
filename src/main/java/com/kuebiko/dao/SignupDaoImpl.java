package com.kuebiko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import com.kuebiko.entity.SignupEntity;
import com.kuebiko.query.SQLQuery;
import com.kuebiko.utils.SQLConnectionUtils;

public class SignupDaoImpl implements SignupDao {

	@Override
	public int signup(String username, String password, String email, String name, String salutation) {
		int count = 0;
		try {
			Date date = new Date();
			Timestamp timestamp = new Timestamp(date.getTime());
			Connection connection = SQLConnectionUtils.getConn();
			// Compiling query and assigning into PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(SQLQuery.INSERT_SIGNUP);
			// setting the values inside PreparedStatement object
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, name);
			pstmt.setString(5, salutation);
			pstmt.setTimestamp(6, timestamp);
			// Fire the query
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public SignupEntity authUser(String username, String password) {
		SignupEntity signupEntity = null;
		try {
			Connection connection = SQLConnectionUtils.getConn();
			// Compiling query and assigning into PreparedStatement object
			PreparedStatement pstmt = connection.prepareStatement(SQLQuery.SELECT_SIGNUP_USERNAME_PASSWORD);
			// setting the values inside PreparedStatement object
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			// Fire the query
			ResultSet rs = pstmt.executeQuery();
			// username,password,email,name,salutation,datecreated
			if (rs.next()) {
				signupEntity = new SignupEntity();
				String email = rs.getString(3);
				String name = rs.getString(4);
				String salutation = rs.getString(5);
				String role = rs.getString(7);
				// Setting values inside request scope
				signupEntity.setEmail(email);
				signupEntity.setName(name);
				signupEntity.setSalutation(salutation);
				signupEntity.setRole(role);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return signupEntity;
	}

}
