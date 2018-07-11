package com.ssh.x.action;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.x.entity.UserEntity;

@Component("teacher")
public class teacher extends BaseAction{
	public boolean check() {
		Map session = ActionContext.getContext().getSession();
		UserEntity user = (UserEntity) session.get("entity");
		if(user!=null)
		{
			if(user.getRole().equals("ΩÃ ¶"))
			{
				return true;
			}
			return false;
		}
		return false;
	}
	public String T_score() throws Exception
	{
		if(check())
		{
			return "T_score";
		}
		return INPUT;
	}

}
