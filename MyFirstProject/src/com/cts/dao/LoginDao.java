package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cts.model.User;
import com.cts.util.DBUtil;

public class LoginDao {
	
	public String  getUser(User user) {
		
		Connection conn=DBUtil.getConnection();
		
		String sql="select name from user where password=?";
		String name="";
		try {
		
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, user.getPassword());
		
		ResultSet rs=stmt.executeQuery();
		
		
		
		 if(rs.next()) {
			name=rs.getString("name");
		 }
		
		}catch(Exception e) {
			
		}
		
		return name;
	}

}
