package com.StrutsAction;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.SSH.ServiceBeanImpls.MessageServiceImpl;
import com.SSH.ServiceBeans.MessageService;
import com.opensymphony.xwork2.ActionSupport;

import com.SSH.ServiceBeans.UserManager;

public class SendMessage extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private UserManager userManager;
	
	@Override
	public String execute() throws Exception {
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		
		String content = java.net.URLDecoder.decode(request.getParameter("content"), "UTF-8");
		String receiver = java.net.URLDecoder.decode(request.getParameter("receiver"), "UTF-8");
		int sen = Integer.parseInt(request.getParameter("sender"));
		
		
		String sender = userManager.getUserName(sen);
		
		Date sendTime = new Date();
		
		MessageService ms = new MessageServiceImpl();
		ms.addMessage(sender, receiver, content, sendTime,ServletActionContext.getRequest().getRealPath("/")+"log.txt");
		
		return "success";
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
}

