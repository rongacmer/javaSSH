package com.ssh.x.entity;

import java.io.Serializable;

public class Selectcourse implements Serializable{
	String cno;
	String sno;
	java.lang.Integer Score;
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public java.lang.Integer getScore() {
		return Score;
	}
	public void setScore(java.lang.Integer score) {
		Score = score;
	}
}
