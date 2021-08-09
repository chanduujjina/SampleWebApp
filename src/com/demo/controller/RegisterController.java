package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entity.UserInfo;
import com.demo.exception.DBConnectionException;
import com.demo.exception.UserDetailedException;
import com.demo.exception.ValidationException;
import com.demo.service.RegitrationService;
import com.demo.validation.UserInfoValidation;

public class RegisterController extends HttpServlet{
	
	RegitrationService service = new RegitrationService();
	UserInfoValidation  validation = new UserInfoValidation(); 
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		UserInfo userInfo = buildUserDetail(req);
		    PrintWriter printWriter = resp.getWriter();
		    printWriter.print("<html>");
	        printWriter.print("<body>");
	
			try {
				validation.validateUserInfo(userInfo);
				service.registerUser(userInfo);
				 printWriter.print("<h1>Registration is Sucess</h1>");
			     printWriter.print("<a href=\"login.html\">click here to login</a>");
			} catch (UserDetailedException | DBConnectionException | ValidationException ex) {
				 printWriter.print("<h1>"+ex.getMessage()+"</h1>");
				 printWriter.print("<a href=\"login.html\">click here to login</a>");
			}
	       
	        printWriter.print("</body>");
	        printWriter.print("</html>");
	}
	
	public UserInfo buildUserDetail(HttpServletRequest req) {
		String userName = req.getParameter("userName");
		String gender = req.getParameter("gender");
		String phone = req.getParameter("phoneNumber");
		String email = req.getParameter("email");
		String password = req.getParameter("psw");
		String repeatPassword = req.getParameter("psw-repeat");
		return new UserInfo(userName, password, gender,phone,email) ;
	}

}
