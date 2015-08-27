package com.SSH.Forms;

public class UserForm {
	private String email;
	private String first_name;
	private String last_name;
	private String pwd;
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
	public UserForm(String email, String first_name, String last_name,
			String pwd) {
		super();
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.pwd = pwd;
	}
	
	public UserForm(String email,String pwd){
		this.email=email;
		this.pwd=pwd;
	}
	
	

}
