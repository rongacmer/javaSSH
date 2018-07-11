package com.ssh.x.service;

import com.ssh.x.entity.Student;
import com.ssh.x.page.studentpaga;

public interface StudentService {
	public studentpaga show();
	public void del(Student stu);
	public boolean add(Student stu);
	public boolean update(Student stu);
}
