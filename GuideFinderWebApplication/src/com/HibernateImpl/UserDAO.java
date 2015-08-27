package com.HibernateImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.Hibernate.BaseDAO;
import com.SSH.Beans.User;


public class UserDAO extends HibernateDaoSupport implements BaseDAO{
	

	@Override
	public void SaveObject(Object obj) throws HibernateException {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(obj);
		
	}

	@Override
	public Object getObjectByEmail(String email) throws HibernateException {
		// TODO Auto-generated method stub
		
		//return getHibernateTemplate().get(User.class,new Integer(email));
		//return getHibernateTemplate()
		@SuppressWarnings("unchecked")
		List<User> list=getHibernateTemplate().find("from User");
		for(User u:list){
			if(u.getEmail().endsWith(email)){
				return u;
			}
		}
		return null;
	}

	@Override
	public Object getObjectByID(String id) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAllObject() throws HibernateException {
		// TODO Auto-generated method stub
		
		return getHibernateTemplate().find("from User");
	}

	@Override
	public void updateObject(Object obj) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObject(Object obj) throws HibernateException {
		// TODO Auto-generated method stub
		
	}



}
