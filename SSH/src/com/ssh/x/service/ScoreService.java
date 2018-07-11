package com.ssh.x.service;

import com.ssh.x.entity.Cno;
import com.ssh.x.entity.Selectcourse;
import com.ssh.x.page.scorepage;
import com.ssh.x.page.sscorepage;

public interface ScoreService {
	public scorepage show(String cno);
	public boolean check(String cname);
	public boolean addscore(Selectcourse sel);
	public boolean comfirm(String cno);
	public sscorepage listscore(String sno);
}
