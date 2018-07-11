package com.ssh.x.action;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("BaseAction")
public class BaseAction extends ActionSupport{
	public void writeJson(Object object) {
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().write(JSON.toJSONString(object));
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
}
	}
}
