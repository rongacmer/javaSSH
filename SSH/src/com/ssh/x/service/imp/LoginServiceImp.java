package com.ssh.x.service.imp;

import org.springframework.stereotype.Service;

import com.ssh.x.entity.UserEntity;
import com.ssh.x.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.ssh.x.dao.LoginDao;
import com.ssh.x.dao.StudnetDao;
import com.ssh.x.dao.TeacherDao;

import org.springframework.stereotype.Component;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
@Service
@Component("LoginService")
public class LoginServiceImp implements LoginService{

	@Autowired
	private LoginDao user;
	@Autowired
	private StudnetDao stu;
	@Autowired
	private TeacherDao tea;
	@Override
	public boolean isLoginSuccess(UserEntity entity) {
		// TODO Auto-generated method stub
		UserEntity account=user.find(entity.getUserName(),entity.getUserPass());
		Map session = ActionContext.getContext().getSession();
		if(account == null)
		{
			return false;
		}
		else
		{
			
			session.put("entity", account);
			if(account.getRole().equals("学生"))
			{
				String x = stu.find(account.getUserName()).getSname();
				session.put("UserName", x);
			}
			else if(account.getRole().equals("教师"))
			{
				String x = tea.findtno(account.getUserName()).getTname();
				session.put("UserName", x);
			}
			else
			{
				session.put("UserName", "root");
			}
			session.put("id", account.getUserName());
			return true;
		}
		
	}
	public LoginDao getUser() {
		return user;
	}
	public void setUser(LoginDao user) {
		this.user = user;
	}
	@Override
	public boolean isEditPassSuccess(String oldpass, String newpass) {
		Map session = ActionContext.getContext().getSession();
		UserEntity user1=null;
		user1=(UserEntity)session.get("entity");
		if(user1.getUserPass().equals(oldpass))
		{
			
			//System.out.println(newpass);
			user1.setUserPass(newpass);
			user1=(UserEntity)session.get("entity");
			//System.out.println(user1.getUserPass());
			user.editpass(user1);
			return true;
		}
		return false;
	}
}
