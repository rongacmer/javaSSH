package com.ssh.x.dao;

import java.util.List;

import com.ssh.x.entity.Cno;
import com.ssh.x.entity.UserEntity;

public interface CnoDao {
	public List<Cno> findall();
	public int isfind(String Tno);
	public Cno findcno(String cname);
	public Cno findct(String cname,String tno);
	public Cno findid(String cno);
	public boolean del(Cno cno);
	public boolean add(Cno cno);
	public boolean update(Cno cno);
	public boolean updateflag(Cno cno);
}
