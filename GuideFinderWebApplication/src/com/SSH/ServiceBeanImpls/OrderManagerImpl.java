package com.SSH.ServiceBeanImpls;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.Hibernate.BaseDAO;
import com.SSH.Beans.Order;
import com.SSH.Beans.Order_Info;
import com.SSH.Forms.OrderForm;
import com.SSH.ServiceBeans.OrderManager;

public class OrderManagerImpl implements OrderManager {
	
	private BaseDAO Dao;
	@Override
	public void saveOrder(OrderForm order) {
		// TODO Auto-generated method stub
		Order o=new Order();
		//Order_Info o=new Order_Info();
		BeanUtils.copyProperties(order, o);
		//o.setOrder_ID(3);
//		System.out.println(o.getCity());
//		System.out.println(o.getGuide_ID());
//		System.out.println(o.getTraveler_ID());
//		System.out.println(o.getStartTime());
//		System.out.println(o.getComment());
//		System.out.println(o.getEndTime());
//		System.out.println(o.getNumber());
		
		
		this.Dao.SaveObject(o);
		
	}

	@Override
	public Object getOrderById(int id) {
		// TODO Auto-generated method stub
		List list=this.Dao.getAllObject();
		Order order;
		for(Object o:list){
			 order=(Order)o;
			if(order.getOrder_ID()==id){
				return order;
			}
		}
		return null;
	}

	public BaseDAO getDao() {
		return Dao;
	}

	public void setDao(BaseDAO orderDAO) {
		this.Dao = orderDAO;
	}

	@Override
	public List getAllOrder() {
		// TODO Auto-generated method stub
		return this.Dao.getAllObject();
	}

	@Override
	public void deleteOrder(int id) {
		Object o=getOrderById(id);
		this.Dao.deleteObject(o);
		
	}
	
	

}
