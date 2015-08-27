package com.SSH.ServiceBeans;

import java.util.List;

import com.SSH.Forms.OrderForm;

public interface OrderManager {
	public void saveOrder(OrderForm order);
	public Object getOrderById(int id);
	public List getAllOrder();
	public void deleteOrder(int id);

}
