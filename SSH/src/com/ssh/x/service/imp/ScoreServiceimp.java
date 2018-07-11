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
import com.ssh.x.entity.Cno;
import com.ssh.x.entity.Selectcourse;
import com.ssh.x.entity.Student;
import com.ssh.x.entity.sscore;
import com.ssh.x.page.scorepage;
import com.ssh.x.page.sscorepage;
import com.ssh.x.service.ScoreService;

@Service
@Component("ScoureService")
public class ScoreServiceimp implements ScoreService{

	@Autowired
	CnoDao cmsg;
	@Autowired
	SelectDao smsg;
	@Autowired
	scorepage page;
	@Autowired
	sscorepage spage;
	public scorepage getPage() {
		return page;
	}

	public void setPage(scorepage page) {
		this.page = page;
	}

	public sscorepage getSpage() {
		return spage;
	}

	public void setSpage(sscorepage spage) {
		this.spage = spage;
	}

	public SelectDao getSmsg() {
		return smsg;
	}

	public void setSmsg(SelectDao smsg) {
		this.smsg = smsg;
	}

	public CnoDao getCmsg() {
		return cmsg;
	}

	public void setCmsg(CnoDao cmsg) {
		this.cmsg = cmsg;
	}

	@Override
	public scorepage show(String cno) {
		// TODO Auto-generated method stub
		List<Selectcourse> list = smsg.finds(cno);
		List<Selectcourse> lists = new ArrayList<>();
		int cnt = 0;
		for(Selectcourse r:list)
		{
			cnt++;
			Selectcourse x = new Selectcourse();
			x.setSno(r.getSno());
			x.setScore(r.getScore());
			lists.add(x);
		}
		page.getRows().clear();
		page.getRows().addAll(lists);
		page.setTotal(cnt);
		return page;
	}

	@Override
	public boolean check(String cname) {
		// TODO Auto-generated method stub
		Map session = ActionContext.getContext().getSession();
		String tno = (String)session.get("id");
		Cno cou = cmsg.findct(cname, tno);
		if(cou == null) return false;
		session.put("cno", cou.getCno());
		return true;
	}
	
	@Override
	public boolean addscore(Selectcourse sel)
	{
		Map session = ActionContext.getContext().getSession();
		String cno = (String)session.get("cno");
		sel.setCno(cno);
		return smsg.update(sel);
	}

	@Override
	public boolean comfirm(String cno) {
		// TODO Auto-generated method stub
		List<Selectcourse> LS = smsg.finds(cno);
		boolean flag = true;
		for(Selectcourse r:LS) {
			if(r.getScore() == null) {
				flag = false;
				return false;
			}
		}
		Cno cc = cmsg.findid(cno);
		cc.setFlag(1);
		cmsg.updateflag(cc);
		return true;
	}
	
	@Override
	public sscorepage listscore(String sno) {
		// TODO Auto-generated method stub
		List<sscore> list = smsg.scorequery(sno);
		List<sscore> lists = new ArrayList<>();
		int cnt = 0;
		for(sscore r:list)
		{
			cnt++;
			sscore stu = new sscore();
			stu.setCredit(r.getCredit());
			stu.setCname(r.getCname());
			stu.setGpa(r.getGpa());
			stu.setScore(r.getScore());
			lists.add(stu);
		}
		spage.getRows().clear();
		spage.getRows().addAll(lists);
		spage.setTotal(cnt);
		return spage;
	}
}
