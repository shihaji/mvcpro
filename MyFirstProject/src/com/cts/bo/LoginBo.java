package com.cts.bo;

import com.cts.dao.LoginDao;
import com.cts.model.User;

public class LoginBo {
	
	public boolean validateUser(User user) {
		
		LoginDao loginDao=new LoginDao();
		
		String username=loginDao.getUser(user);
		
		if(username.equals(user.getName())) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
