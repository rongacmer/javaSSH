package com.weibo.util;

import com.weibo.entity.Comments;

public class Commentpage implements Comparable<Commentpage>{
	int size;
	Comments comment;
	String reply;
	
	public Commentpage(int size, Comments comment, String reply) {
		super();
		this.size = size;
		this.comment = comment;
		this.reply = reply;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Comments getComment() {
		return comment;
	}
	public void setComment(Comments comment) {
		this.comment = comment;
	}
	@Override
	public int compareTo(Commentpage o) {
		// TODO Auto-generated method stub
		if(this.getComment().getId()>o.getComment().getId()){
			return 1;
		}
		else
		return -1;
	}
}
