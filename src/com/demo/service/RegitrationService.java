package com.demo.service;

import java.sql.SQLException;

import com.demo.dao.RegistrationDao;
import com.demo.dao.RegistrationDaoImpl;
import com.demo.entity.UserInfo;

public class RegitrationService {
	
	RegistrationDao dao = new RegistrationDaoImpl();
	
	public void registerUser(UserInfo info) throws SQLException, ClassNotFoundException {
		dao.saveUser(info);
	}
	
	public boolean isAuthenticate(String userName,String password) throws ClassNotFoundException, SQLException {
		UserInfo info =dao.getCredentials(userName, password);
		
		return info != null ?true:false;
	}
	
	

}
