package com.cts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.bo.LoginBo;
import com.cts.model.User;


@WebServlet("/loginServlet")
public class LoginController extends HttpServlet {
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		
	   User user=new User();
	   
	   user.setName(name);
	   user.setPassword(password);
	   
	   LoginBo loginBo=new LoginBo();
	   
	   if(loginBo.validateUser(user)) {
		   request.getRequestDispatcher("home.jsp").forward(request, response);
		   
	   }else {
		   response.sendRedirect("login.jsp");
	   }
	   
	   

		
		
	}

}
