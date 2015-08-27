package com.SSH.ServiceBeans;

import com.SSH.Beans.User;
import com.SSH.Forms.UserForm;

public interface UserManager {
	public void registerUser(UserForm userForm);
	public int loginUser(UserForm userForm);
	public String getUserName(int id);
	public User getUserEntity(UserForm userForm);

}
