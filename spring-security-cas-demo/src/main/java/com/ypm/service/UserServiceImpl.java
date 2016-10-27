package com.ypm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypm.interfaces.IUserDao;
import com.ypm.interfaces.IUserService;
import com.ypm.model.User;

@Service
public class UserServiceImpl implements IUserService{
	
   @Autowired
	private IUserDao userDao;
   
	@Override
	public User getUserInfoByUserName(String userName) {

		return userDao.getUserInfoByUserName(userName);
	}

}
