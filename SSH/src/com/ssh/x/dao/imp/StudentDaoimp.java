package com.ssh.x.dao.imp;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.x.dao.BaseDAO;
import com.ssh.x.dao.LoginDao;
import com.ssh.x.dao.StudnetDao;
import com.ssh.x.entity.Student;
import com.ssh.x.entity.UserEntity;

@Service
@Repository("StudentDao")
public class StudentDaoimp  extends BaseDAO implements StudnetDao {
	@Autowired
	LoginDao user_;
	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public List<Student> findall(){
		Session session = null;
		Transaction ts = null;
		List<Student> list = null;
		try {
			String hql= "from Student";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
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

	public LoginDao getUser_() {
		return user_;
	}

	public void setUser_(LoginDao user_) {
		this.user_ = user_;
	}

	@Override
	public void del(Student stu) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.delete(stu);
			ts.commit();
			
		}catch(Exception e)
		{
			if(ts != null)
			{
				ts.rollback();
				System.out.println(e);
			}
		}
		finally {
			session.close();
		}
		user_.del(stu.getId());
	}

	@Override
	public boolean add(Student stu) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.save(stu);
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
		x.setRole("学生");
		x.setUserName(stu.getId());
		x.setUserPass("123456");
		return user_.add(x);
	}

	@Override
	public boolean update(Student stu) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.update(stu);
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
	public Student find(String id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List<Student> list = null;
		Student user = null;;
		try {
			String hql= "from Student where id=?";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			list = query.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				if (list.size() != 0) {
					user = (Student) it.next();// 创建持久化的JavaBean对象user
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
		return user;
	}

}
