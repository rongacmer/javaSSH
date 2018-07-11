package com.ssh.x.dao.imp;

import com.ssh.x.dao.BaseDAO;
import com.ssh.x.dao.LoginDao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ssh.x.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Repository("LoginDao")
public class LoginDaoimp extends BaseDAO implements LoginDao{
	@Override
	public UserEntity find(String userName, String Password) {
		Session session = null;
		Transaction ts = null;
		UserEntity user = null;
		try {
			String hql= "from UserEntity u where u.userName = ? and u.userPass = ?";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, userName);
			query.setParameter(1,Password);
			List users = query.list();
			Iterator it = users.iterator();
			while (it.hasNext()) {
				if (users.size() != 0) {
					user = (UserEntity) it.next();// 创建持久化的JavaBean对象user
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
	public void editpass(UserEntity user) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.update(user);
			ts.commit();
		}catch(Exception e)
		{
			if(ts != null)
			{
				System.out.println(e);
				ts.rollback();
			}
		}finally {
			session.close();
		}
	}

	@Override
	public boolean del(String userName) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			String hql = "Delete FROM UserEntity Where id=?" ;
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, userName);
			query.executeUpdate();
			ts.commit();
		}catch(Exception e)
		{
			if(ts != null)
			{
				System.out.println(e);
				ts.rollback();
				session.close();
				return false;
			}
		}finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean add(UserEntity user) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.save(user);
			ts.commit();
		}catch(Exception e)
		{
			if(ts != null)
			{
				System.out.println(e);
				ts.rollback();
				session.close();
				return false;
			}
		}finally {
			session.close();
		}
		return true;
		
	}
}
