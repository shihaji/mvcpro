package com.cts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.dao.EmployeeDao;
import com.cts.model.Employee;

/**
 * Servlet implementation class EmployeeRegister
 */
@WebServlet("/EmployeeRegister")
public class EmployeeRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String salary=request.getParameter("salary");
		
		Employee emp=new Employee();
		
		emp.setId(Integer.parseInt(id));
		emp.setName(name);
		emp.setSalary(Integer.parseInt(salary));
		
		EmployeeDao empDao=new EmployeeDao();
		HttpSession session=request.getSession();
		
		if(empDao.registerEmployee(emp)) {
			session.setAttribute("status", "Employee successfully added");
			response.sendRedirect("home.jsp");
		}else {
			session.setAttribute("status", "Employee was not added");
			response.sendRedirect("home.jsp");
		}
		
		
	}

}
