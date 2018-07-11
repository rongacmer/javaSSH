package com.ssh.x.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.util.JSON;
import com.ssh.x.dao.CnoDao;
import com.ssh.x.page.studentpaga;
import com.ssh.x.service.CnoService;
import com.ssh.x.service.SelectService;

@Component("selectbean")
public class SelectAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SelectService selectservice;
	private String cno;
	private String sno;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public SelectService getSelectservice() {
		return selectservice;
	}
	public void setSelectservice(SelectService selectservice) {
		this.selectservice = selectservice;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String output() throws Exception{
		Map session = ActionContext.getContext().getSession();
		cno = (String)session.get("cno");
		studentpaga page = selectservice.show(cno);
		this.writeJson(page);
		return null;
	}
	public String selq() throws Exception{
		System.out.println("query");
		JSON json=new JSON();
		try {
			if(selectservice.find(cno))
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
		JSON json=new JSON();
		try {
			if(selectservice.addsno(sno))
			{
				json.setSuccess(true);
				json.setMsg("增加成功");
			}
			else 
			{
				json.setSuccess(false);
				json.setMsg("增加失败");
			}
		
		}catch(Exception e) {
			json.setSuccess(false);
			json.setMsg("增加失败");
		}
		super.writeJson(json);
		return null;
	}
	public String update() throws Exception{
		JSON json=new JSON();
		try {
			if(selectservice.addsno(sno))
			{
				json.setSuccess(true);
				json.setMsg("增加成功");
			}
			else 
			{
				json.setSuccess(false);
				json.setMsg("增加失败");
			}
		
		}catch(Exception e) {
			json.setSuccess(false);
			json.setMsg("增加失败");
		}
		super.writeJson(json);
		return null;
	}
	public String del() throws Exception{
		JSON json=new JSON();
		try {
			if(selectservice.delsno(sno))
			{
				json.setSuccess(true);
				json.setMsg("增加成功");
			}
			else 
			{
				json.setSuccess(false);
				json.setMsg("增加失败");
			}
		
		}catch(Exception e) {
			json.setSuccess(false);
			json.setMsg("增加失败");
		}
		super.writeJson(json);
		return null;
	}

}
