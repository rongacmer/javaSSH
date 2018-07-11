package com.ssh.x.dao;

import java.util.List;



import com.ssh.x.entity.Student;


public interface StudnetDao{
	public List<Student> findall();
	public Student find(String id);
	public void del(Student stu);
	public boolean add(Student stu);
	public boolean update(Student stu);
}
