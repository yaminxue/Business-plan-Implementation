package com.SSH.ServiceBeans;

import com.SSH.Beans.GPS;

public interface GPSManager {
	public void saveGPS(GPS gps);
	public GPS getGPS(int user_ID);
	public void updateGPS(GPS gps);
}
