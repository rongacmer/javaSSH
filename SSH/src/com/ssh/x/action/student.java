package com.ssh.x.action;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.x.entity.UserEntity;

@Component("student")
public class student extends BaseAction{
	public boolean check() {
		Map session = ActionContext.getContext().getSession();
		UserEntity user = (UserEntity) session.get("entity");
		if(user!=null)
		{
			if(user.getRole().equals("Ñ§Éú"))
			{
				return true;
			}
			return false;
		}
		return false;
	}
	public String S_score() throws Exception
	{
		if(check())
		{
			return "S_score";
		}
		return INPUT;
	}

}
