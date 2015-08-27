package com.Hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface BaseDAO {
	public void SaveObject(Object obj) throws HibernateException;
	public Object getObjectByEmail(String email) throws HibernateException;
	public Object getObjectByID(String id) throws HibernateException;
	public List getAllObject() throws HibernateException;
	public void updateObject(Object obj) throws HibernateException;
	public void deleteObject(Object obj) throws HibernateException;
}
