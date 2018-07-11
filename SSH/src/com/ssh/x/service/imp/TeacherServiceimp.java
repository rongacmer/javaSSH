package com.ssh.x.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ssh.x.dao.CnoDao;
import com.ssh.x.dao.TeacherDao;
import com.ssh.x.entity.Teacher;
import com.ssh.x.page.teacherpage;
import com.ssh.x.service.TeacherService;

@Service
@Component("TeacherService")
public class TeacherServiceimp implements TeacherService{

	@Autowired
	private TeacherDao msg;
	@Autowired
	private CnoDao cmsg ;
	@Autowired
	private teacherpage page;


	public TeacherDao getMsg() {
		return msg;
	}

	public void setMsg(TeacherDao msg) {
		this.msg = msg;
	}

	public CnoDao getCmsg() {
		return cmsg;
	}

	public void setCmsg(CnoDao cmsg) {
		this.cmsg = cmsg;
	}

	public teacherpage getPage() {
		return page;
	}

	public void setPage(teacherpage page) {
		this.page = page;
	}
	@Override	
	public teacherpage show() {
		List<Teacher> list = msg.findall();
		List<Teacher> lists = new ArrayList<>();
		int cnt = 0;
		for(Teacher r:list)
		{
			cnt++;
			Teacher tea = new Teacher();
			tea.setTno(r.getTno());
			tea.setPhone(r.getPhone());
			tea.setTSex(r.getTSex());
			tea.setTname(r.getTname());
			lists.add(tea);

		}
		page.getRows().clear();
		page.getRows().addAll(lists);
		page.setTotal(cnt);
		return page;
	}

	@Override
	public boolean del(Teacher tea) {
		// TODO Auto-generated method stub
		int size = cmsg.isfind(tea.getTno());
		if(size == 0)
		return msg.del(tea);
		return false;
	}

	@Override
	public boolean add(Teacher tea) {
		// TODO Auto-generated method stub
		return msg.add(tea);
	}

	@Override
	public boolean update(Teacher tea) {
		// TODO Auto-generated method stub
		return msg.update(tea);
	}
	
}
