package com.ssh.x.action;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.x.entity.UserEntity;

@Component("manager")
public class manager extends BaseAction{
	public boolean check() {
		Map session = ActionContext.getContext().getSession();
		UserEntity user = (UserEntity) session.get("entity");
		if(user!=null)
		{
			if(user.getRole().equals("π‹¿Ì‘±"))
			{
				return true;
			}
			return false;
		}
		return false;
	}
	public String M_student() throws Exception
	{
		if(check())
		{
			return "M_student";
		}
		return INPUT;
	}
	public String M_teacher() throws Exception
	{
		if(check())
		{
			return "M_teacher";
		}
		return INPUT;
	}
	public String M_course() throws Exception
	{
		if(check())
		{
			return "M_course";
		}
		return INPUT;
	}
	public String M_selectcourse() throws Exception
	{
		if(check())
		{
			return "M_selectcourse";
		}
		return INPUT;
	}
}
