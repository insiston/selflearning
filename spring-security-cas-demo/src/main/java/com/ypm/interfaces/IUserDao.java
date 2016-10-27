package com.ypm.interfaces;

import com.ypm.model.User;

public interface IUserDao {
	
	User getUserInfoByUserName(String userName);
}
