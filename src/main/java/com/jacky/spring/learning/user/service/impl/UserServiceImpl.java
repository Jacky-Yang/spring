package com.jacky.spring.learning.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jacky.spring.learning.user.dao.LoginLogDao;
import com.jacky.spring.learning.user.dao.UserDao;
import com.jacky.spring.learning.user.domain.LoginLog;
import com.jacky.spring.learning.user.domain.User;
import com.jacky.spring.learning.user.service.IUserService;


@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;

	@Override
	public int getMatchCount(String userName, String password) {
		return userDao.getMatchCount(userName, password);
	}

	@Override
	public User findByName(String userName) {
		return userDao.findByName(userName);
	}
	
	@Transactional(readOnly = false)
	public void loginSuccess(User user) {
		user.setCredits(5 + user.getCredits());
		
		LoginLog log = new LoginLog();
		log.setUserId(user.getUserId());
		log.setIp(user.getLastIp());
		log.setLoginDate(user.getLastVist());
		
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(log);
	}

}
