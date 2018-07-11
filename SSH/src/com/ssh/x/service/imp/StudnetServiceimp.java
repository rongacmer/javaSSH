package com.ssh.x.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ssh.x.entity.Student;
import com.ssh.x.dao.LoginDao;
import com.ssh.x.page.studentpaga;
import com.ssh.x.service.StudentService;
import com.ssh.x.dao.StudnetDao;

@Service
@Component("StudentService")
public class StudnetServiceimp implements StudentService{

	@Autowired
	private StudnetDao mes;
	@Autowired
	private studentpaga page;
	public StudnetDao getMes() {
		return mes;
	}
	public void setMes(StudnetDao mes) {
		this.mes = mes;
	}
	public studentpaga getPaga() {
		return page;
	}
	public void setPaga(studentpaga page) {
		this.page = page;
	}
	@Override
	public studentpaga show() {
		List<Student> list = mes.findall();
		List<Student> lists = new ArrayList<>();
		int cnt = 0;
		for(Student r:list)
		{
			cnt++;
			Student stu = new Student();
			stu.setId(r.getId());
			stu.setPhone(r.getPhone());
			stu.setSex(r.getSex());
			stu.setSname(r.getSname());
			lists.add(stu);

		}
		page.getRows().clear();
		page.getRows().addAll(lists);
		page.setTotal(cnt);
		return page;
	}
	@Override
	public void del(Student stu) {
		mes.del(stu);
		// TODO Auto-generated method stub
	}
	@Override
	public boolean add(Student stu) {
		// TODO Auto-generated method stub
		return mes.add(stu);
	}
	@Override
	public boolean update(Student stu) {
		// TODO Auto-generated method stub
		return mes.update(stu);
	}
}
