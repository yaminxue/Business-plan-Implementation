package com.SSH.ServiceBeanImpls;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;

import com.Hibernate.BaseDAO;
import com.HibernateImpl.UserDAO;
import com.SSH.Beans.User;
import com.SSH.Forms.UserForm;
import com.SSH.ServiceBeans.UserManager;
import com.Security.EncryptionUtil;
import com.mysql.jdbc.Util;

public class UserManagerImpl implements UserManager {
	private BaseDAO Dao;
	
	public void setDao(BaseDAO dao){
		this.Dao=dao;
		
	}
	

	@Override
	public void registerUser(UserForm userForm){
		User user=new User();
		BeanUtils.copyProperties(userForm, user);
		this.Dao.SaveObject(user);
	}
//	public void registerUser(UserForm userForm) {
//		// TODO Auto-generated method stub
//		this.session=HibernateSessionFactory.currentSession();
//		this.Dao.setSession(this.session);
//		Transaction transaction=this.session.beginTransaction();
//		User user=new User();
//		user.setEmail(userForm.getEmail());
//		user.setFirst_name(userForm.getFirst_name());
//		user.setLast_name(userForm.getLast_name());
//		user.setPwd(userForm.getPwd());
//		this.Dao.SaveObject(user);
//		transaction.commit();
//		HibernateSessionFactory.closeSession();
//	}



	@Override
	public int loginUser(UserForm userForm)  {
		// TODO Auto-generated method stub
		User user=(User)this.Dao.getObjectByEmail(userForm.getEmail());
//		try {
//			EncryptionUtil enUtil=new EncryptionUtil();
//			System.out.println(enUtil.decrypt(user.getPwd()));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		if(user==null){
			return 0;
		}
		if(user.getPwd().equals(userForm.getPwd())){
			
			return user.getID();
		}
		return 0;
		
	}


	@Override
	public String getUserName(int id) {
		// TODO Auto-generated method stub
		List list=this.Dao.getAllObject();
		String username="";
		for(Object o:list){
			User u=(User)o;
			if(u.getID()==id){
				username = u.getFirst_name()+" "+u.getLast_name();
				break;
			}
		}
		//System.out.println(username);
		return username;
		
	}


	@Override
	public User getUserEntity(UserForm userForm) {
		User user=(User)this.Dao.getObjectByEmail(userForm.getEmail());
		if(user.getPwd().equals(userForm.getPwd())){
			return user;
		}
		else{
			return null;
		}
	}

}
