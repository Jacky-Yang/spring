package com.jacky.spring.learning.user.domain;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8412425917425607448L;
	
	private int id;
	
	private int userId;
	
	private String ip;
	
	private Date loginDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
