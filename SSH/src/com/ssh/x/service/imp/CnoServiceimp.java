package com.ssh.x.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ssh.x.dao.CnoDao;
import com.ssh.x.dao.TeacherDao;
import com.ssh.x.entity.Cno;
import com.ssh.x.entity.Teacher;
import com.ssh.x.page.cnopage;
import com.ssh.x.service.CnoService;

@Service
@Component("CnoService")
public class CnoServiceimp implements CnoService{

	@Autowired
	private CnoDao msg;
	@Autowired
	private cnopage page;
	@Autowired
	private TeacherDao tmsg;
	public CnoDao getMsg() {
		return msg;
	}

	public void setMsg(CnoDao msg) {
		this.msg = msg;
	}

	public cnopage getPage() {
		return page;
	}

	public void setPage(cnopage page) {
		this.page = page;
	}

	@Override
	public cnopage show() {
		// TODO Auto-generated method stub
		List<Cno> list = msg.findall();
		List<Cno> lists = new ArrayList<>();
		int cnt = 0;
		for(Cno r:list)
		{
			cnt++;
			Cno cno = new Cno();
			cno.setCname(r.getCname());
			cno.setCno(r.getCno());
			cno.setGPA(r.getGPA());
			cno.setTno(r.getTno());
			cno.setTname(r.getTname());
			lists.add(cno);
		}
		page.getRows().clear();
		page.getRows().addAll(lists);
		page.setTotal(cnt);
		return page;
		
	}

	@Override
	public boolean del(Cno cno) {
		// TODO Auto-generated method stub
		return msg.del(cno);
	}

	@Override
	public boolean add(Cno cno) {
		// TODO Auto-generated method stub
		if((cno.getTno()==null||cno.getTno().equals("")) && (cno.getTname() == null||cno.getTname().equals("")))
		{
			return msg.add(cno);
		}
		Teacher tea = new Teacher();
		tea.setTname(cno.getTname());
		tea.setTno(cno.getTno());
		if(tmsg.find(tea)!=null) {
			return msg.add(cno);
		}
		return false;
	}

	@Override
	public boolean update(Cno cno) {
		// TODO Auto-generated method stub
		if((cno.getTno()==null||cno.getTno().equals("")) && (cno.getTname() == null||cno.getTname().equals("")))
		{
			return msg.update(cno);
		}
		Teacher tea = new Teacher();
		tea.setTname(cno.getTname());
		tea.setTno(cno.getTno());
		if(tmsg.find(tea)!=null) {
			return msg.update(cno);
		}
		return false;
	}
	

	
}
