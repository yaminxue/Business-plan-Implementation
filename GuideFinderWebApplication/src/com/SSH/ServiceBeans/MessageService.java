package com.SSH.ServiceBeans;

import java.util.Date;
import java.util.List;


public interface MessageService {
	
	public void addMessage(String sender, String receiver, String content, Date sendTime,String path);
	public String readMessage(String receiver,String path);
	public String getMessage(String receiver,String sender,String path);
	public List<String> androidreadMessage(String receiver, String path);
	public List<String> androidgetMessage(String receiver,String sender,String path);

}
