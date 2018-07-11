package com.ssh.x.page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssh.x.entity.Student;

@Component("studentpaga")
public class studentpaga {
	private List<Student> rows = new ArrayList<>();
	private long total;
	public List<Student> getRows() {
		return rows;
	}
	public void setRows(List<Student> rows) {
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
}
