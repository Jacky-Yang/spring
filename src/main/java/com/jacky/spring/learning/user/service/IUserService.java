package com.jacky.spring.learning.user.service;

import com.jacky.spring.learning.user.domain.User;

public interface IUserService {
	
	int getMatchCount(String userName, String password);
	
	User findByName(String userName);

}
