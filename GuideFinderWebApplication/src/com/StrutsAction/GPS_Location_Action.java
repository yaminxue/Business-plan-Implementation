package com.StrutsAction;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SSH.Beans.GPS;
import com.SSH.Beans.Order;
import com.SSH.ServiceBeans.GPSManager;
import com.SSH.ServiceBeans.OrderManager;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GPS_Location_Action extends ActionSupport implements 
			ServletRequestAware,ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String user_ID;
	private String longtitude;
	private String latitude;
	
	private GPSManager manager;
	private OrderManager orderManager;
	
	private Map<String,Object> dataMap;
	
	public String storeGPS(){
		GPS gps=new GPS();
		gps.setDatetime(new Timestamp(new Date().getTime()));
		gps.setLatitude(Double.valueOf(latitude));
		gps.setLongtitude(Double.valueOf(longtitude));
		gps.setUser_ID(Integer.valueOf(user_ID));
		
		Object object=this.manager.getGPS(gps.getUser_ID());
		if(object!=null){
			this.manager.updateGPS(gps);
		}else{
			this.manager.saveGPS(gps);
		}
		return SUCCESS;
	}
	public String getGPS() throws ParseException{
		List list=this.orderManager.getAllOrder();
		int guide_ID=0;
		for(Object o:list){
			Order order=(Order)o;
			if(order.getTraveler_ID()==Integer.valueOf(user_ID)){
				
				//System.out.println(guide_ID);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date startDate=sdf.parse(order.getStartTime());
				Date endDate=sdf.parse(order.getEndTime());
				Date nowDate=new Date();
				if(nowDate.after(startDate)&&nowDate.before(endDate)){
					guide_ID=order.getGuide_ID();
					break;
				}
				
			}
			if(order.getGuide_ID()==Integer.valueOf(user_ID)){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date startDate=sdf.parse(order.getStartTime());
				Date endDate=sdf.parse(order.getEndTime());
				Date nowDate=new Date();
				if(nowDate.after(startDate)&&nowDate.before(endDate)){
					guide_ID=order.getTraveler_ID();
					break;
				}
			}
		}
		if(guide_ID!=0){
			GPS gps=(GPS)this.manager.getGPS(guide_ID);
			//System.out.println(gps.getLatitude());
			dataMap.put("guideGPS", gps);
			dataMap.put("success",true);
		}else{
			dataMap.put("success", false);
		}
		return SUCCESS;
	}
	

	public GPS_Location_Action() {
		super();
		dataMap=new HashMap<String,Object>();
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public GPSManager getManager() {
		return manager;
	}

	public void setManager(GPSManager manager) {
		this.manager = manager;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response=arg0;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request=arg0;
		
	}


	public OrderManager getOrderManager() {
		return orderManager;
	}


	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	
	

}
