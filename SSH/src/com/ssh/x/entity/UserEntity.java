package com.ssh.x.entity;

import java.io.Serializable; 
public class UserEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Integer userID;
	private String userName;
	private String userPass;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
}
