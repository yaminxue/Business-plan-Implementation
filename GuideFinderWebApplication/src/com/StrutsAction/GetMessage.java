package com.StrutsAction;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.SSH.ServiceBeanImpls.MessageServiceImpl;
import com.SSH.ServiceBeans.MessageService;
import com.SSH.ServiceBeans.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class GetMessage extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private UserManager userManager;

	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		PrintWriter out = response.getWriter();
		
		int rec = Integer.parseInt(request.getParameter("receiver"));
		int sen = Integer.parseInt(request.getParameter("sender"));
		String receiver = userManager.getUserName(rec);
		String sender = userManager.getUserName(sen);
		
		MessageService ms = new MessageServiceImpl();
		
		out.print(ms.getMessage(receiver,sender,ServletActionContext.getRequest().getRealPath("/")+"log.txt"));
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