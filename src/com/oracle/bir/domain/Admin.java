package com.oracle.bir.domain;

import java.io.Serializable;

public class Admin implements Serializable {

	private static final long serialVersionUID = 5320659924344524691L;

	private int uid;
	private String username;
	private String password;
	
	public Admin() {
		
	}

	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [uid=" + uid + ", username=" + username + ", password="
				+ password + "]";
	}
	
}
