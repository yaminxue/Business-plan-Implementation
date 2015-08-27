package com.StrutsAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SSH.Beans.Order;
import com.SSH.ServiceBeans.OrderManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Android_OrderAction extends ActionSupport
			implements ServletRequestAware,ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private OrderManager manager;
	
	private Map<String,Object> dataMap;
	private String User_ID;

	public Android_OrderAction() {
		super();
		dataMap=new HashMap<String,Object>();
	}
	
	public String getOrder(){
		//int ID =(int)ActionContext.getContext().getSession().get("id");
		int ID=Integer.valueOf(User_ID);
		List list=this.manager.getAllOrder();
		List<Order> orderList=new ArrayList<Order>();
		for(Object o:list){
			Order order=(Order)o;
			if(order.getTraveler_ID()==ID){
				orderList.add(order);
			}
		}
		dataMap.put("orderlist", orderList);
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response=arg0;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request=arg0;
		
	}

	public OrderManager getManager() {
		return manager;
	}

	public void setManager(OrderManager manager) {
		this.manager = manager;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}
	

}
