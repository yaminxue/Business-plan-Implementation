package com.StrutsAction;

import com.SSH.Forms.OrderForm;
import com.SSH.ServiceBeans.OrderManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OrderAddAction extends ActionSupport{
	private OrderManager manager;
	
	private OrderForm order;
	private int guide_ID;
	private String startTime;
	private String endTime;
	private String number;
	private String city;
	private int travel_ID;
	private String comment;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			setOrder();
			this.manager.saveOrder(order);
			System.out.println("yes");
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		
		
	}
	
	private void setOrder(){
		this.order=new OrderForm();
		this.order.setCity(city);
		this.order.setComment(comment);
		this.order.setEndTime(endTime);
		this.order.setStartTime(startTime);
		this.order.setGuide_ID((int)ActionContext.getContext().getSession().get("temporaryGuide"));
		this.order.setTraveler_ID((int)ActionContext.getContext().getSession().get("id"));
		this.order.setNumber(Integer.valueOf(this.number));
	}
	public OrderManager getManager() {
		return manager;
	}
	public void setManager(OrderManager manager) {
		this.manager = manager;
	}
	public OrderForm getOrder() {
		return order;
	}
	public void setOrder(OrderForm order) {
		this.order = order;
	}
	public int getGuide_ID() {
		return guide_ID;
	}
	public void setGuide_ID(int guide_ID) {
		this.guide_ID = guide_ID;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getTravel_ID() {
		return travel_ID;
	}
	public void setTravel_ID(int travel_ID) {
		this.travel_ID = travel_ID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
