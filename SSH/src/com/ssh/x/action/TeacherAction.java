package com.ssh.x.action;

import com.ssh.util.JSON;
import com.ssh.x.action.BaseAction;
import com.ssh.x.entity.Teacher;
import com.ssh.x.page.studentpaga;
import com.ssh.x.page.teacherpage;
import com.ssh.x.service.TeacherService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("teacherbean")
public class TeacherAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TeacherService teacherservice;
	private Teacher tea;

	public TeacherService getTeacherservice() {
		return teacherservice;
	}
	public void setTeacherservice(TeacherService teacherservice) {
		this.teacherservice = teacherservice;
	}
	public Teacher getTea() {
		return tea;
	}
	public void setTea(Teacher tea) {
		this.tea = tea;
	}
	public String output() throws Exception{
		teacherpage page = teacherservice.show();
		this.writeJson(page);
		return null;
	}
	public String del() throws Exception{
		JSON json=new JSON();
			if(teacherservice.del(tea))
			{
				json.setSuccess(true);
				json.setMsg("ɾ���ɹ�");
			}
			else 
			{
				json.setSuccess(false);
				json.setMsg("ɾ��ʧ��");
			}
		super.writeJson(json);
		return null;
	}
	public String add() throws Exception{
//		System.out.println(stu.getId());
		JSON json=new JSON();
		try {
			if(teacherservice.add(tea))
			{
				json.setSuccess(true);
				json.setMsg("���ӳɹ�");
			}
			else 
			{
				json.setSuccess(false);
				json.setMsg("����ʧ��");
			}
		
		}catch(Exception e) {
			json.setSuccess(false);
			json.setMsg("����ʧ��");
		}
		super.writeJson(json);
		return null;
	}
	public String update() throws Exception{
		System.out.println(tea.getTno());
		JSON json=new JSON();
		try {
			if(teacherservice.update(tea))
			{
				json.setSuccess(true);
				json.setMsg("�޸ĳɹ�");
			}
			else 
			{
				json.setSuccess(false);
				json.setMsg("�޸�ʧ��");
			}
		
		}catch(Exception e) {
			json.setSuccess(false);
			json.setMsg("�޸�ʧ��");
		}
		super.writeJson(json);
		return null;
	}
}
