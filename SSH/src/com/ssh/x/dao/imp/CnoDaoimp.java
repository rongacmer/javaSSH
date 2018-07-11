package com.ssh.x.dao.imp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ssh.x.dao.BaseDAO;
import com.ssh.x.dao.CnoDao;
import com.ssh.x.entity.Cno;
import com.ssh.x.entity.UserEntity;

@Service
@Repository("CnoDao")
public class CnoDaoimp extends BaseDAO implements CnoDao{

	@Override
	public List<Cno> findall() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List<Cno> LS = null;
		try {
			String hql = "from Cno where Tno is null  or Tno = '' ";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			LS = query.list();
			hql = "select C,T.Tname from Cno C,Teacher T where C.Tno = T.Tno";
			query = session.createQuery(hql);
			List<?> LT = query.list();
			for(int i = 0; i < LT.size(); i++)
			{
				Object[] object = (Object[])LT.get(i);
				Cno x = (Cno) object[0];
				String y = (String) object[1];
				x.setTname(y);
				LS.add(x);
			}
			ts.commit();
		}catch(Exception e)
		{
			System.out.println(e);
			if(ts != null)
			{
				ts.rollback();
			}
			
		}finally {
			session.close();
		}
		return LS;
	}

	@Override
	public boolean del(Cno cno) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			String hql = "Delete FROM Cno Where Cno=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, cno.getCno());
			query.executeUpdate();
			ts.commit();
			
		}catch(Exception e)
		{
			if(ts != null)
			{
				ts.rollback();
				System.out.println(e);
				session.close();
				return false;
			}
		}
		finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean add(Cno cno) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.save(cno);
			ts.commit();
			
		}catch(Exception e)
		{
			if(ts != null)
			{
				ts.rollback();
				System.out.println(e);
				session.close();
				return false;
			}
		}
		finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean update(Cno cno) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			String hql = "update Cno c set c.Cname = ?,c.GPA = ?, c.Tno = ? where c.Cno=?";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, cno.getCname());
			query.setParameter(1, cno.getGPA());
			query.setParameter(2, cno.getTno());
			query.setParameter(3, cno.getCno());
			query.executeUpdate();
			ts.commit();
		}catch(Exception e)
		{
			if(ts != null)
			{
				ts.rollback();
				System.out.println(e);
				session.close();
				return false;
			}
		}finally {
			session.close();
		}
		return true;
	}
	
	@Override
	public boolean updateflag(Cno cno)
	{
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.update(cno);
			ts.commit();
		}catch(Exception e)
		{
			if(ts != null)
			{
				ts.rollback();
				System.out.println(e);
				session.close();
				return false;
			}
		}finally {
			session.close();
		}
		return true;
	}

	@Override
	public int isfind(String Tno) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List<Cno> LS = null;
		try {
			String hql = "from Cno where Tno = ?";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, Tno);
			LS = query.list();
			ts.commit();
		}catch(Exception e)
		{
			System.out.println(e);
			if(ts != null)
			{
				ts.rollback();
			}
			
		}finally {
			session.close();
		}
		if(LS==null)
			return 0;
		else
		return LS.size();
	}

	@Override
	public Cno findcno(String Cname) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List<Cno> LS = null;
		Cno cs = null;
		try {
			String hql = "from Cno where Cname = ?";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, Cname);
			LS = query.list();
			Iterator it = LS.iterator();
			while (it.hasNext()) {
				if (LS.size() != 0) {
					cs = (Cno) it.next();// 创建持久化的JavaBean对象user
				}
			}
			ts.commit();
		}catch(Exception e)
		{
			System.out.println(e);
			if(ts != null)
			{
				ts.rollback();
			}
			
		}finally {
			session.close();
		}
		return cs;
	}

	@Override
	public Cno findct(String cname, String tno) {
		Session session = null;
		Transaction ts = null;
		List<Cno> LS = null;
		Cno cs = null;
		try {
			String hql = "from Cno where Cname = ? and Tno = ?";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, cname);
			query.setParameter(1, tno);
			LS = query.list();
			Iterator it = LS.iterator();
			while (it.hasNext()) {
				if (LS.size() != 0) {
					cs = (Cno) it.next();// 创建持久化的JavaBean对象user
				}
			}
			ts.commit();
		}catch(Exception e)
		{
			System.out.println(e);
			if(ts != null)
			{
				ts.rollback();
			}
			
		}finally {
			session.close();
		}
		return cs;
	}

	@Override
	public Cno findid(String cno) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List<Cno> LS = null;
		Cno cs = null;
		try {
			String hql = "from Cno where Cno = ?";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, cno);
			LS = query.list();
			Iterator it = LS.iterator();
			while (it.hasNext()) {
				if (LS.size() != 0) {
					cs = (Cno) it.next();// 创建持久化的JavaBean对象user
				}
			}
			ts.commit();
		}catch(Exception e)
		{
			System.out.println(e);
			if(ts != null)
			{
				ts.rollback();
			}
			
		}finally {
			session.close();
		}
		return cs;
	}
}
