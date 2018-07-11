package com.ssh.x.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.x.dao.CnoDao;
import com.ssh.x.dao.SelectDao;
import com.ssh.x.dao.StudnetDao;
import com.ssh.x.entity.Cno;
import com.ssh.x.entity.Selectcourse;
import com.ssh.x.entity.Student;
import com.ssh.x.entity.sscore;
import com.ssh.x.page.studentpaga;
import com.ssh.x.service.SelectService;
import com.ssh.x.page.sscorepage;

@Service
@Component("SelectServiceimp")
public class SelectServiceimp implements SelectService{

	@Autowired
	private StudnetDao smsg;
	@Autowired
	private SelectDao msg;
	@Autowired
	private studentpaga page;
	@Autowired
	private CnoDao cmsg;
	@Autowired
	private sscorepage spage;
	@Override
	public studentpaga show(String cno) {
		// TODO Auto-generated method stub
		List<Student> list = msg.findall(cno);
		List<Student> lists = new ArrayList<>();
		int cnt = 0;
		for(Student r:list)
		{
			cnt++;
			Student stu = new Student();
			stu.setId(r.getId());
			stu.setSname(r.getSname());
			lists.add(stu);

		}
		page.getRows().clear();
		page.getRows().addAll(lists);
		page.setTotal(cnt);
		return page;
	}
	@Override
	public boolean find(String cname) {
		// TODO Auto-generated method stub
		Cno cs = cmsg.findcno(cname);
		if(cs != null)
		{
			Map session = ActionContext.getContext().getSession();
			session.put("cno", cs.getCno());
			return true;
		}
		return false;
	}
	@Override
	public boolean addsno(String sno) {
		// TODO Auto-generated method stub
		Map session = ActionContext.getContext().getSession();
		String cno = (String) session.get("cno");
		if(cno == null) return false;
		if(smsg.find(sno)==null) return false;
		Selectcourse s = new Selectcourse();
		s.setCno(cno);
		s.setSno(sno);
		return msg.add(s);
	}
	@Override
	public boolean delsno(String sno) {
		// TODO Auto-generated method stub
		Map session = ActionContext.getContext().getSession();
		String cno = (String) session.get("cno");
		Selectcourse s = new Selectcourse();
		s.setCno(cno);
		s.setSno(sno);
		return msg.del(s);
	}
	
}
