package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cts.model.Employee;
import com.cts.util.DBUtil;

public class EmployeeDao {
	
	
	public boolean registerEmployee(Employee employee) {
		
		Connection conn=DBUtil.getConnection();
		
		String sql="insert into employee values(?,?,?)";
		
		try {
		
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, employee.getId());
		ps.setString(2, employee.getName());
		ps.setInt(3,employee.getSalary());
		
		ps.execute();
		return true;
		
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public List<Employee> getAllEmployee(){
		List<Employee> list=new ArrayList<Employee>();
		Connection conn=DBUtil.getConnection();
		String sql="select * from employee";
		try {
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		ResultSet rs=stmt.executeQuery();
		
		
		while(rs.next()) {
			
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int salary=rs.getInt("salary");
			
			Employee emp=new Employee();
			emp.setId(id);
			emp.setName(name);
			emp.setSalary(salary);
			list.add(emp);
		}
		
		}catch(Exception e) {
			
		}
		
		return list;
	}

}
