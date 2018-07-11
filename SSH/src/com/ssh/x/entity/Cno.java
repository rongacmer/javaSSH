package com.ssh.x.entity;

import java.io.Serializable;

public class Cno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Cno;
	private String Cname;
	private float GPA;	//绩点
	private String Tno;	//任课教师教工号
	private String Tname;
	private int flag;//成绩是否发布	
	
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public float getGPA() {
		return GPA;
	}
	public void setGPA(float gPA) {
		GPA = gPA;
	}
	

}
