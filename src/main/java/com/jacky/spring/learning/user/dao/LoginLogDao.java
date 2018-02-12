package com.jacky.spring.learning.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jacky.spring.learning.user.domain.LoginLog;

@Repository
public class LoginLogDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertLoginLog(LoginLog log) {
		
		String sql = "insert into t_login_log(user_id, ip, login_datetime) values(?, ?, ?)";
		Object[] args = new Object[] {log.getUserId(), log.getIp(), log.getLoginDate()};
		jdbcTemplate.update(sql, args);
	}
}
