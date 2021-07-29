package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.entity.UserInfo;
import com.demo.utility.DBUtility;

public class RegistrationDaoImpl implements RegistrationDao{
	


	@Override
	public void saveUser(UserInfo userInfo) throws SQLException, ClassNotFoundException {
		Connection conn =DBUtility.getConnection();
		
		String sql = "insert into UserDetail (UserName,Password,Gender,PhoneNumber,email) values(?,?,?,?,?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setString(1, userInfo.getUserName());
		statement.setString(2, userInfo.getPassword());
		statement.setString(3, userInfo.getGender());
		statement.setString(4, userInfo.getPhoneNumber());
		statement.setString(5, userInfo.getEmail());
		statement.execute();
		
	}

	@Override
	public UserInfo getCredentials(String userName, String password) throws ClassNotFoundException, SQLException {
		
		Connection conn =DBUtility.getConnection();
		String sql = "select * from UserDetail where UserName = ? and Password =?";
		PreparedStatement statement =conn.prepareStatement(sql);
		statement.setString(1, userName);
		statement.setString(2, password);
		
		statement.execute();
		 ResultSet resultset =  statement.getResultSet();
		 UserInfo info = null;
		while(resultset.next()) {
			info = new UserInfo(resultset.getString("UserName"), resultset.getString("Password"), resultset.getString("Gender"), 
					resultset.getString("PhoneNumber"), resultset.getString("email"));
			break;
		}
		return info;
	}

}
