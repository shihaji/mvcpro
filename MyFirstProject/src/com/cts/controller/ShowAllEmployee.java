package com.cts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.dao.EmployeeDao;

/**
 * Servlet implementation class ShowAllEmployee
 */
@WebServlet("/showAllEmployee")
public class ShowAllEmployee extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDao empDao=new EmployeeDao();
		
		HttpSession session=request.getSession();
	    
		session.setAttribute("allEmp", empDao.getAllEmployee());
		
		response.sendRedirect("home.jsp");
		
		
	}

}
