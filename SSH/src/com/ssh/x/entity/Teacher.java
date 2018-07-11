package com.ssh.x.entity;

import java.io.Serializable;
import com.ssh.x.entity.UserEntity;
public class Teacher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Tno;
	private String Tname;
	private String TSex;
	private String phone;
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getTSex() {
		return TSex;
	}
	public void setTSex(String tSex) {
		TSex = tSex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
