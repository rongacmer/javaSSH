package com.ssh.x.dao.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ssh.x.dao.BaseDAO;
import com.ssh.x.dao.LoginDao;
import com.ssh.x.dao.TeacherDao;
import com.ssh.x.entity.Teacher;
import com.ssh.x.entity.UserEntity;

@Service
@Repository("TeacherDao")
public class TeacherDaoimp extends BaseDAO implements TeacherDao{
	@Autowired
	LoginDao user_;

	public LoginDao getUser_() {
		return user_;
	}

	public void setUser_(LoginDao user_) {
		this.user_ = user_;
	}

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public List<Teacher> findall() {
		Session session = null;
		Transaction ts = null;
		List<Teacher> LS = null;
		try {
			String hql="from Teacher";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
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
		return LS;
	}

	@Override
	public boolean del(Teacher tea) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.delete(tea);
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
		return user_.del(tea.getTno());
	}

	@Override
	public boolean add(Teacher tea) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.save(tea);
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
		UserEntity x = new UserEntity();
		x.setRole("教师");
		x.setUserName(tea.getTno());
		x.setUserPass("123456");
		return user_.add(x);
	}

	@Override
	public boolean update(Teacher tea) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.update(tea);
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
	public Teacher find(Teacher tea) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		Teacher user = null;
		try {
			String hql= "from Teacher u where u.Tno = ? and u.Tname = ?";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, tea.getTno());
			query.setParameter(1,tea.getTname());
			List users = query.list();
			Iterator it = users.iterator();
			while (it.hasNext()) {
				if (users.size() != 0) {
					user = (Teacher) it.next();// 创建持久化的JavaBean对象user
				}
			}
			ts.commit();
		}catch(Exception e)
		{
			if(ts != null)
			{
				ts.rollback();
			}
		}finally {
			session.close();
		}
		return user;
	}
	
	@Override
	public Teacher findtno(String tno) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		Teacher user = null;
		try {
			String hql= "from Teacher u where u.Tno = ?";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, tno);
			List users = query.list();
			Iterator it = users.iterator();
			while (it.hasNext()) {
				if (users.size() != 0) {
					user = (Teacher) it.next();// 创建持久化的JavaBean对象user
				}
			}
			ts.commit();
		}catch(Exception e)
		{
			if(ts != null)
			{
				ts.rollback();
			}
		}finally {
			session.close();
		}
		return user;
	}
	
}
