package com.SSH.ServiceBeanImpls;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.Hibernate.BaseDAO;
import com.HibernateImpl.UserDAO;
import com.SSH.Beans.Guide;
import com.SSH.Beans.Guide_Info;
import com.SSH.Forms.GuideForm;
import com.SSH.ServiceBeans.GuideManager;

public class GuideManagerImpl implements GuideManager {
	private BaseDAO Dao;
	

	@Override
	public void Register(GuideForm guideForm) {
		// TODO Auto-generated method stub
		Guide_Info info=new Guide_Info();
		BeanUtils.copyProperties(guideForm, info);
		
		
		this.Dao.SaveObject(info);
		
		
	}
	

	public BaseDAO getDao() {
		return Dao;
	}

	public void setDao(BaseDAO gDAO) {
		Dao = gDAO;
	}


	@Override
	public List GetGuideList() {
		// TODO Auto-generated method stub
		return this.Dao.getAllObject();
	}

	
	
}
