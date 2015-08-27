package com.StrutsAction;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.SSH.Beans.User;
import com.SSH.Forms.UserForm;
import com.SSH.ServiceBeans.UserManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Android_UserLoginAction extends ActionSupport 
			implements ServletRequestAware, ServletResponseAware {
	private HttpServletResponse response;
	private HttpServletRequest request;
	
	private String email;
	private String pwd;
	private String first_name;
	private String last_name;
	
	private UserManager manager;
	
	private Map<String,Object> dataMap;
	

	public Android_UserLoginAction() {
		super();
		dataMap=new HashMap<String,Object>();
	}
	

	
	public String login() throws Exception {
		dataMap.clear();
		UserForm userForm=new UserForm(email,pwd);
		int id;
		if((id=this.manager.loginUser(userForm))!=0){
			this.dataMap.put("success", true);
			//ActionContext.getContext().getSession().put("id", id);
			User user=this.manager.getUserEntity(userForm);
			this.dataMap.put("user", user);
		}
		else{
			this.dataMap.put("success", false);
			this.dataMap.put("user",null);
		}
		return SUCCESS;
	}
	
	public String register(){
		dataMap.clear();
		UserForm userForm=new UserForm(email,first_name,last_name,pwd);
		try{
			this.manager.registerUser(userForm);
			this.dataMap.put("signup", true);
		}catch(Exception e){
			this.dataMap.put("signup", false);
		}
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public UserManager getManager() {
		return manager;
	}


	public void setManager(UserManager manager) {
		this.manager = manager;
	}


	public Map<String, Object> getDataMap() {
		return dataMap;
	}


	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
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



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	
	
}
