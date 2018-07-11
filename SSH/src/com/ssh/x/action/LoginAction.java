package com.ssh.x.action;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.util.JSON;
import com.ssh.x.action.BaseAction;
import com.ssh.x.entity.UserEntity;
import com.ssh.x.service.LoginService;

import org.springframework.stereotype.Component;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@Component("loginbean")
public class LoginAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private LoginService service;
	private UserEntity entity;
	private String OldPass;
	private String NewPass;
	private String userName;
	private String info;
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getOldPass() {
		return OldPass;
	}
	public void setOldPass(String oldPass) {
		OldPass = oldPass;
	}
	public String getNewPass() {
		return NewPass;
	}
	public void setNewPass(String newPass) {
		NewPass = newPass;
	}
	public UserEntity getEntity() {
		return entity;
	}
	public LoginService getService() {
		return service;
	}
	public void setService(LoginService service) {
		this.service = service;
	}
	public void setEntity(UserEntity entity) {
		this.entity = entity;
	}
	public String execute() throws Exception{
		info="";
		Map session = ActionContext.getContext().getSession();
		session.clear();
		return "success";
	}
	public String dl() throws Exception{
		System.out.println(entity.getUserName());
		System.out.println(entity.getUserPass());
		if(service.isLoginSuccess(entity))
		{
			Map session = ActionContext.getContext().getSession();
			userName = (String) session.get("UserName");
			entity = (UserEntity) session.get("entity");
			System.out.println(entity.getRole());
			return entity.getRole();
		}
		else {
			info="µÇÂ½Ê§°Ü";
			return "input";
		}
		
	}
	public String editpass() throws Exception{
		JSON json=new JSON();
		try {
			if(service.isEditPassSuccess(OldPass, NewPass))
			{
				json.setSuccess(true);
				json.setMsg("ÐÞ¸Ä³É¹¦,»Øµ½µÇÂ½½çÃæ");
			}
			else 
			{
				json.setSuccess(false);
				json.setMsg("ÃÜÂë´íÎó");
			}
		
		}catch(Exception e) {
			json.setSuccess(false);
			json.setMsg("ÐÞ¸ÄÊ§°Ü");
		}
		super.writeJson(json);
		return null;
	}
	public String test() {
		System.out.println(info);
		return SUCCESS;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
