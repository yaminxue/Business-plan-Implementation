package com.StrutsAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.SSH.Beans.Order;
import com.SSH.ServiceBeans.OrderManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OrderDetailAction extends ActionSupport{
	private OrderManager manager;
	
	private String orderID;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List list=this.manager.getAllOrder();
		List<Order> orderList=new ArrayList<Order>();
		for(Object o:list){
			Order ob=(Order)o;
			if(ob.getTraveler_ID()==(int)ActionContext.getContext().getSession().get("id")){
				orderList.add(ob);
			}
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("orderList", orderList);
		return null;
	}
	public String orderDelete(){
		this.manager.deleteOrder(Integer.valueOf(orderID));
		return SUCCESS;
	}
	public OrderManager getManager() {
		return manager;
	}
	public void setManager(OrderManager manager) {
		this.manager = manager;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	
	
	

}
