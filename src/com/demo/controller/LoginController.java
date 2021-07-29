package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.RegitrationService;

public class LoginController extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		RegitrationService service = new RegitrationService();
		
		String userName = req.getParameter("userName");
		
		String password = req.getParameter("psw");
		Boolean isAuthenticate = null;
		try {
			isAuthenticate =service.isAuthenticate(userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 PrintWriter printWriter = resp.getWriter();

		    printWriter.print("<html>");
	        printWriter.print("<body>");
	        if(isAuthenticate) {
	        printWriter.print("<h1>Login is Sucess</h1>");
	        printWriter.print("<h1>This Website is under constrction</h1>");
	        }
	        else {
	        	 printWriter.print("<h1>Incorrect UserName or Password</h1>");
	        }
	       
	        printWriter.print("</body>");
	        printWriter.print("</html>");
	}

}
