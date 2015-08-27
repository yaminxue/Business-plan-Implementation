package com.SSH.ServiceBeanImpls;

import com.Hibernate.BaseDAO;
import com.SSH.Beans.GPS;
import com.SSH.ServiceBeans.GPSManager;

public class GPSManagerImpl implements GPSManager {
	private BaseDAO dao;

	@Override
	public void saveGPS(GPS gps) {
		this.dao.SaveObject(gps);
		
	}

	@Override
	public GPS getGPS(int user_ID) {
		Object object=this.dao.getObjectByID(String.valueOf(user_ID));
		return (GPS)object;
	}

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	@Override
	public void updateGPS(GPS gps) {
		this.dao.updateObject(gps);
		
	}
	

}
