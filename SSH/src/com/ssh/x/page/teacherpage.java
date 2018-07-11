package com.ssh.x.page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


import com.ssh.x.entity.Teacher;

@Component("teacherpage")
public class teacherpage {
	private List<Teacher> rows = new ArrayList<>();
	private long total;
	public List<Teacher> getRows() {
		return rows;
	}
	public void setRows(List<Teacher> rows) {
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
}
