package com.ssh.x.page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssh.x.entity.Cno;
import com.ssh.x.entity.Student;

@Component("cnopage")
public class cnopage {
	private List<Cno> rows = new ArrayList<>();
	private long total;	
	public List<Cno> getRows() {
		return rows;
	}
	public void setRows(List<Cno> rows) {
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
}
