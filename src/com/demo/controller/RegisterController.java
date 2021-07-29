package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entity.UserInfo;
import com.demo.service.RegitrationService;

public class RegisterController extends HttpServlet{
	
	RegitrationService service = new RegitrationService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		UserInfo userInfo = buildUserDetail(req);
		
		try {
			service.registerUser(userInfo);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  PrintWriter printWriter = resp.getWriter();

		    printWriter.print("<html>");
	        printWriter.print("<body>");
	        printWriter.print("<h1>Registration is Sucess</h1>");
	      
	        printWriter.print("<a href=\"login.html\">click here to login</a>");
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
