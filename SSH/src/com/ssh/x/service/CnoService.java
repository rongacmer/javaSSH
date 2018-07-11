package com.ssh.x.service;

import com.ssh.x.entity.Cno;
import com.ssh.x.page.cnopage;

public interface CnoService {
	public cnopage show();
	public boolean del(Cno cno);
	public boolean add(Cno cno);
	public boolean update(Cno cno);
}
