package com.demo.dao;

import java.sql.SQLException;

import com.demo.entity.UserInfo;

public interface RegistrationDao {
	
	void saveUser(UserInfo userInfo) throws SQLException, ClassNotFoundException;
	
	UserInfo getCredentials(String userName,String password) throws ClassNotFoundException, SQLException;

}
