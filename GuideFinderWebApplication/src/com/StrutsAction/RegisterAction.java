package com.StrutsAction;

import com.SSH.Forms.UserForm;
import com.SSH.ServiceBeanImpls.UserManagerImpl;
import com.SSH.ServiceBeans.UserManager;
import com.Security.EncryptionUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4372628250024014309L;
	private String email;
	private String first_name;
	private String last_name;
	private String pwd;
	private UserForm User;
	private UserManager userManager;
	private EncryptionUtil enUtil;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	

	public UserForm getUser() {
		return User;
	}

	public void setUser() throws Exception {
		User = new UserForm(this.email,this.first_name,this.last_name,this.pwd);
//		String encrypedPwd=enUtil.encrypt(User.getPwd());
//		User.setPwd(encrypedPwd);
	}
	public void setUserManager(UserManager userManager){
		this.userManager=userManager;
	}
	

	public EncryptionUtil getEnUtil() {
		return enUtil;
	}

	public void setEnUtil(EncryptionUtil enUtil) {
		this.enUtil = enUtil;
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		try{
			setUser();
			this.userManager.registerUser(this.User);
			int id;
			if((id=this.userManager.loginUser(this.User))!=0){
				ActionContext.getContext().getSession().put("email", this.User.getEmail());
				ActionContext.getContext().getSession().put("id", id);
				//System.out.println(ActionContext.getContext().getSession().get("id"));
				
			}
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}

}
