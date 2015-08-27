package com.StrutsAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SSH.ServiceBeanImpls.MessageServiceImpl;
import com.SSH.ServiceBeans.MessageService;
import com.SSH.ServiceBeans.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AndroidMessage extends ActionSupport 
implements ServletRequestAware, ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;
	private HttpServletRequest request;
	
	private int guide_ID;
	private int userID;
	private int guide_ID1;
	private int userID1;
	private int userID2;
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	private UserManager manager;
	private String content;
	
	private Map<String,Object> dataMap;
	

	public AndroidMessage() {
		super();
		dataMap=new HashMap<String,Object>();
	}
	
	public String showMessage() throws Exception {
		dataMap.clear();
		MessageService ms = new MessageServiceImpl();
		List<String> msgls = new ArrayList<String>();
		if(userID!=0){
			//System.out.print(userID);
			String userName = manager.getUserName(userID);
			msgls = ms.androidreadMessage(userName, ServletActionContext.getRequest().getRealPath("/")+"log.txt");
			this.dataMap.put("login", true);
			this.dataMap.put("msgls",msgls);
		}
		else{
			this.dataMap.put("login", false);
		}
		return SUCCESS;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public int getGuide_ID() {
		return guide_ID;
	}

	public void setGuide_ID(int guide_ID) {
		this.guide_ID = guide_ID;
	}

	public UserManager getManager() {
		return manager;
	}

	public void setManager(UserManager manager) {
		this.manager = manager;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String sendMessage() throws Exception {
		dataMap.clear();
		Date sendTime = new Date();
		MessageService ms = new MessageServiceImpl();
		if(userID1!=0){
			String userName = manager.getUserName(userID1);
			String guideName = manager.getUserName(guide_ID);
			ms.addMessage(userName, guideName, content, sendTime, ServletActionContext.getRequest().getRealPath("/"+"log.txt"));
			this.dataMap.put("sendmsg", true);
		}
		else
			this.dataMap.put("sendmsg",false);
		
		return SUCCESS;
	}
	
	public String getMessage() throws Exception {
		dataMap.clear();
		MessageService ms = new MessageServiceImpl();
		List<String> msgls = new ArrayList<String>();
		if(userID2!=0){
			String userName = manager.getUserName(userID2);
			String guideName = manager.getUserName(guide_ID1);
			msgls = ms.androidgetMessage(userName, guideName, ServletActionContext.getRequest().getRealPath("/")+"log.txt");
				this.dataMap.put("msgls",msgls);
		}
		return SUCCESS;
	}
	

	public int getGuide_ID1() {
		return guide_ID1;
	}

	public void setGuide_ID1(int guide_ID1) {
		this.guide_ID1 = guide_ID1;
	}

	public int getUserID1() {
		return userID1;
	}

	public void setUserID1(int userID1) {
		this.userID1 = userID1;
	}

	public int getUserID2() {
		return userID2;
	}

	public void setUserID2(int userID2) {
		this.userID2 = userID2;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

}
