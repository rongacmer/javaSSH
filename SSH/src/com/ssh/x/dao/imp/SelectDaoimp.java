package com.ssh.x.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ssh.x.dao.BaseDAO;
import com.ssh.x.dao.SelectDao;
import com.ssh.x.entity.Cno;
import com.ssh.x.entity.Selectcourse;
import com.ssh.x.entity.Student;
import com.ssh.x.entity.sscore;

@Repository("SelectDao")
public class SelectDaoimp extends BaseDAO implements SelectDao{

	@Override
	public List<Student> findall(String cno) {
		Session session = null;
		Transaction ts = null;
		List<Student> list = null;
		try {
			String hql="select y from Selectcourse s,Student y where s.cno= ? and y.id = s.sno";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, cno);
			list = query.list();
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
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public boolean del(Selectcourse sel) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.delete(sel);
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
	public boolean add(Selectcourse sel) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.save(sel);
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
	public List<Selectcourse> finds(String cno) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List<Selectcourse> list = null;
		try {
			String hql="from Selectcourse s where s.cno= ?";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, cno);
			list = query.list();
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
		return list;
	}

	@Override
	public boolean update(Selectcourse sel) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.update(sel);
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
	public List<sscore> scorequery(String sno) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction ts = null;
		List<sscore> list = new ArrayList<>();
		try {
			String hql="select s,c from Selectcourse s,Cno c where s.sno = ? and s.cno=c.Cno and c.flag = 1";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query = session.createQuery(hql);
			query.setParameter(0, sno);
			List<?> LT = query.list();
			for(int i = 0; i < LT.size(); i++)
			{
				Object[] object = (Object[])LT.get(i);
				Cno c = (Cno) object[1];
				Selectcourse s = (Selectcourse) object[0];
				sscore ss = new sscore();
				ss.setCname(c.getCname());
				ss.setCredit(c.getGPA());
				int fenshu = s.getScore();
				float GPA = (float) Math.max(1.0, (fenshu-60)*1.0/10+1.0);
				ss.setGpa(GPA);
				ss.setScore(fenshu);
				list.add(ss);
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
		return list;
	}
}
