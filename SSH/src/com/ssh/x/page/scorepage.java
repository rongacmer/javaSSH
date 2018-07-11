package com.ssh.x.page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssh.x.entity.Cno;
import com.ssh.x.entity.Selectcourse;
import com.ssh.x.entity.Student;

@Component("scorepage")
public class scorepage {
	private List<Selectcourse> rows = new ArrayList<>();
	private long total;
	public List<Selectcourse> getRows() {
		return rows;
	}
	public void setRows(List<Selectcourse> rows) {
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}	

}
