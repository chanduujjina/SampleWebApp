package com.demo.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	
	
		public static Connection getConnection() throws SQLException, ClassNotFoundException {
			 Class.forName("com.mysql.jdbc.Driver");  
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chandudb", "root", "root");
		}
	

}
