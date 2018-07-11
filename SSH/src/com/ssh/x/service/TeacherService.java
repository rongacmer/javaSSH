package com.ssh.x.service;

import com.ssh.x.entity.Teacher;
import com.ssh.x.page.teacherpage;

public interface TeacherService {
	public teacherpage show();
	public boolean del(Teacher tea);
	public boolean add(Teacher tea);
	public boolean update(Teacher tea);
}
