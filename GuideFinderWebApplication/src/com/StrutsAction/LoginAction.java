package com.StrutsAction;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.SSH.Forms.UserForm;
import com.SSH.ServiceBeans.UserManager;
import com.Security.EncryptionUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1606978365234598824L;
	
	private String email;
	private String pwd;
	private UserForm user;
	private UserManager userManager;
	private EncryptionUtil enUtil;
	
	public EncryptionUtil getEnUtil() {
		return enUtil;
	}
	public void setEnUtil(EncryptionUtil enUtil) {
		this.enUtil = enUtil;
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
	public void setUser() throws Exception{
		this.user=new UserForm(this.email,this.pwd);
//		String encryptedPwd=enUtil.encrypt(this.user.getPwd());
//		this.user.setPwd(encryptedPwd);
//		System.out.println(encryptedPwd);
		
	}
	public void setUserManager(UserManager userManager){
		this.userManager=userManager;
		
	}
	@Override
	public String execute() throws Exception {
		
		setUser();
		int id;
		if((id=this.userManager.loginUser(this.user))!=0){
			ActionContext.getContext().getSession().put("email", this.user.getEmail());
			ActionContext.getContext().getSession().put("id", id);
			//System.out.println(ActionContext.getContext().getSession().get("id"));
			
			return SUCCESS;
			
		}
		return ERROR;
		
		
	}
	

}
