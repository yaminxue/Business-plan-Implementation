package com.HibernateImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.Hibernate.BaseDAO;
import com.SSH.Beans.GPS;

public class GPSDAO extends HibernateDaoSupport implements BaseDAO{

	@Override
	public void SaveObject(Object obj) throws HibernateException {
		getHibernateTemplate().save(obj);
		
	}

	@Override
	public Object getObjectByEmail(String email) throws HibernateException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Object getObjectByID(String id) throws HibernateException {
		// TODO Auto-generated method stub
		List list=getAllObject();
		for(Object o:list){
			GPS gps=(GPS)o;
			if(gps.getUser_ID()==Integer.valueOf(id)){
				return gps;
			}
		}
		return null;
	}

	@Override
	public List getAllObject() throws HibernateException {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from GPS");
	}

	@Override
	public void updateObject(Object obj) throws HibernateException {
		getHibernateTemplate().update((GPS)obj);
		
	}

	@Override
	public void deleteObject(Object obj) throws HibernateException {
		// TODO Auto-generated method stub
		
	}
	

}
