package com.ssh.x.dao;

import java.util.List;

import com.ssh.x.entity.Selectcourse;
import com.ssh.x.entity.Student;
import com.ssh.x.entity.sscore;

public interface SelectDao {
	public List<Student> findall(String cno);
	public List<Selectcourse> finds(String cno);
	public boolean del(Selectcourse sel);
	public boolean add(Selectcourse sel);
	public boolean update(Selectcourse sel);
	public List<sscore> scorequery(String sno);
}
