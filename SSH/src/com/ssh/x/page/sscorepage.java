package com.ssh.x.page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssh.x.entity.Selectcourse;
import com.ssh.x.entity.sscore;

@Component("sscorepage")
public class sscorepage {
	private List<sscore> rows = new ArrayList<>();
	private long total;
	public List<sscore> getRows() {
		return rows;
	}
	public void setRows(List<sscore> rows) {
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
}
