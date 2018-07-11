package com.ssh.x.service;

import com.ssh.x.page.sscorepage;
import com.ssh.x.page.studentpaga;

public interface SelectService {
		public studentpaga show(String cno);
		public boolean find(String cname);
		public boolean addsno(String sno);
		public boolean delsno(String sno);
}
