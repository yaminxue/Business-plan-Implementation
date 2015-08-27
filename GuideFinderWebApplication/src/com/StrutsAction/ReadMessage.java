package com.StrutsAction;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.SSH.ServiceBeanImpls.MessageServiceImpl;
import com.SSH.ServiceBeanImpls.UserManagerImpl;
import com.SSH.ServiceBeans.MessageService;
import com.SSH.ServiceBeans.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class ReadMessage extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private UserManager userManager;

	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		PrintWriter out = response.getWriter();
		
		//String receiver = java.net.URLDecoder.decode(request.getParameter("receiver"), "UTF-8");
		//String sender = java.net.URLDecoder.decode(request.getParameter("sender"), "UTF-8");
		int rec = Integer.parseInt(request.getParameter("receiver"));
//		int sender = Integer.parseInt(request.getParameter("sender"));
		//System.out.println(receiver+sender);
		
		String receiver = userManager.getUserName(rec);
		
		MessageService ms = new MessageServiceImpl();
		//ms.readMessage(receiver, sender);
		//System.out.println(ms.readMessage(receiver));
		
		out.print(ms.readMessage(receiver,ServletActionContext.getRequest().getRealPath("/")+"log.txt"));
		out.close();

		return "success";
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	

}