package com.Junit4.Test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.SSH.Forms.UserForm;
import com.SSH.ServiceBeanImpls.GuideManagerImpl;
import com.SSH.ServiceBeans.UserManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:WebContent/WEB-INF/applicationContext.xml"}) 
public class UserManageTest extends AbstractJUnit4SpringContextTests {
	@Resource
	private UserManager userManager;
	//private GuideManagerImpl guideManager;

	@Test
	public void RegisterTest() {
		//fail("Not yet implemented");
//		UserForm userForm=new UserForm("zhuyu@123.com","zhu","yunyi","123456");
//		userManager.registerUser(userForm);
	}
	@Test
	public void LoginTest(){
//		UserForm userForm=new UserForm("zhuyu@123.com","123456");
//		userManager.loginUser(userForm);
	}
	
	@Test
	public void GetTest(){
		//this.guideManager.GetAllObject();
	}

}
