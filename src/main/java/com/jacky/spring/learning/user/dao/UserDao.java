package com.jacky.spring.learning.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.jacky.spring.learning.user.domain.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getMatchCount(String userName, String password) {
		String sql = "select * from t_user where user_name = ? and password = ?";
		
		User user = jdbcTemplate.queryForObject(sql, new Object[] {userName, password}, User.class);
		
		return user == null ? 0: 1;
	}
	
	public User findByName(String userName) {
		String sql = "select user_id, user_name, credits from t_user where user_name = ?";
		final User user = new User();
		user.setUserName(userName);
		jdbcTemplate.query(sql, new Object[] {userName}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				user.setUserId(rs.getInt("user_id"));
				user.setCredits(rs.getInt("credits"));
			}
		});
		
		return user;
	}
	
	public void updateLoginInfo(User user) {
		String sql = "update t_user set last_visit = ?, last_ip = ?, credits = ? where user_id = ?";
		
		jdbcTemplate.update(sql,new Object[] {user.getLastVist(), user.getLastIp(), user.getCredits(), user.getUserId() });
	}

}
