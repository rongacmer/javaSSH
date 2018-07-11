package com.ssh.x.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.util.JSON;
import com.ssh.x.entity.Selectcourse;
import com.ssh.x.page.scorepage;
import com.ssh.x.page.sscorepage;
import com.ssh.x.service.ScoreService;

@Component("scorebean")
public class ScoreAction extends BaseAction{
	
	String cname;
	@Autowired
	ScoreService service;
	Selectcourse sco;
	public ScoreService getService() {
		return service;
	}
	public void setService(ScoreService service) {
		this.service = service;
	}


	public Selectcourse getSco() {
		return sco;
	}
	public void setSco(Selectcourse sco) {
		this.sco = sco;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String output() throws Exception{
		Map session = ActionContext.getContext().getSession();
//		session.put("tno","15151");
		String cno = (String) session.get("cno");
		scorepage page = service.show(cno);
		this.writeJson(page);
		return null;
	}

	public String Scocheck() throws Exception{
		System.out.println("check");
		JSON json=new JSON();
		try {
			if(service.check(cname))
			{
				json.setSuccess(true);
				json.setMsg("查询成功");
			}
			else 
			{
				json.setSuccess(false);
				json.setMsg("不存在该课程");
			}
		
		}catch(Exception e) {
			json.setSuccess(false);
			json.setMsg("查询失败");
		}
		super.writeJson(json);
		return null;
	}
	public String add() throws Exception{
		System.out.println("add");
		JSON json=new JSON();
		try {
			if(service.addscore(sco))
			{
				json.setSuccess(true);
				json.setMsg("保存成功");
			}
			else 
			{
				json.setSuccess(false);
				json.setMsg("保存失败");
			}
		
		}catch(Exception e) {
			json.setSuccess(false);
			json.setMsg("保存失败");
		}
		super.writeJson(json);
		return null;
	}
	public String comfirm() throws Exception{
		System.out.println("add");
		JSON json=new JSON();
		Map session = ActionContext.getContext().getSession();
		String cc = (String)session.get("cno");
		try {
			if(service.comfirm(cc))
			{
				json.setSuccess(true);
				json.setMsg("提交成功");
			}
			else 
			{
				json.setSuccess(false);
				json.setMsg("还有未录入成绩");
			}
		
		}catch(Exception e) {
			json.setSuccess(false);
			json.setMsg("提交失败");
		}
		super.writeJson(json);
		return null;
	}
	public String enquire() throws Exception{
		Map session = ActionContext.getContext().getSession();
//		session.put("id", "3115005251");
		String cc = (String)session.get("id");
		sscorepage page = service.listscore(cc);
		this.writeJson(page);
		return null;
		
	}
}
