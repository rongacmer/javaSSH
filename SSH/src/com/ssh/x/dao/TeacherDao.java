package com.ssh.x.dao;

import java.util.List;




import com.ssh.x.entity.Teacher;


public interface TeacherDao{
	public List<Teacher> findall();
	public Teacher find(Teacher tea);
	public boolean del(Teacher tea);
	public boolean add(Teacher tea);
	public boolean update(Teacher tea);
	public Teacher findtno(String tno);
}
