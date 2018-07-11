package com.ssh.x.service;

import org.springframework.stereotype.Service;
import com.ssh.x.entity.UserEntity;

public interface LoginService {
	public boolean isLoginSuccess(UserEntity entity);
	public boolean isEditPassSuccess(String oldpass,String newpass);
}
