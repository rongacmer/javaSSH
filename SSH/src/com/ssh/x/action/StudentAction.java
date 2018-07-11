package com.ssh.x.action;

import com.ssh.util.JSON;
import com.ssh.x.action.BaseAction;
import com.ssh.x.entity.Student;
import com.ssh.x.page.studentpaga;
import com.ssh.x.service.StudentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("studentbean")
public class StudentAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private StudentService studentservice;
	private Student stu;
	private int total;
	
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public int getTotla() {
		return total;
	}
	public void setTotla(int total) {
		this.total = total;
	}
	public StudentService getStudentservice() {
		return studentservice;
	}
	public void setStudentservice(StudentService studentservice) {
		this.studentservice = studentservice;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String output() throws Exception{
		studentpaga page = studentservice.show();
		this.writeJson(page);
		return null;
	}
	public String del() throws Exception{
		System.out.println(stu.getId());
		studentservice.del(stu);
		return null;
	}
	public String add() throws Exception{
//		System.out.println(stu.getId());
		JSON json=new JSON();
		try {
			if(studentservice.add(stu))
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
		System.out.println(stu.getId());
		JSON json=new JSON();
		try {
			if(studentservice.update(stu))
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
