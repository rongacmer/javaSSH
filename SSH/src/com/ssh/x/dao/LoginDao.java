package com.ssh.x.dao;



import com.ssh.x.entity.UserEntity;


public interface LoginDao {
	public UserEntity find(String userName, String userPass);
	public void editpass(UserEntity user);
	public boolean del(String userName);
	public boolean add(UserEntity user);
}
