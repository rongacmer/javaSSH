package com.ssh.x.entity;

import java.io.Serializable;

import com.ssh.x.entity.UserEntity;

public class Student implements Serializable,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String Sname;
	private String Sex;
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Object clone() throws CloneNotSupportedException{  
            return super.clone();  
    } 
	
}
