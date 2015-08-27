package com.SSH.Beans;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GPS {
	private int user_ID;
	private double latitude;
	private double longtitude;
	private Timestamp datetime;
	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int user_ID) {
		
		this.user_ID = user_ID;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	
	

}
