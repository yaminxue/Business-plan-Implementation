package com.Junit4.Test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Hibernate.BaseDAO;
import com.HibernateImpl.GuideDAO;
import com.HibernateImpl.UserDAO;
import com.SSH.Beans.Guide_Info;
import com.SSH.Beans.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:WebContent/WEB-INF/applicationContext.xml"}) 
public class UserDAOTest extends AbstractJUnit4SpringContextTests{
	@Resource 
	private UserDAO UserDao;
	

	@Test
	public void Savetest() {
		//fail("Not yet implemented");
//		User user1=new User("zhuyu@123.com","zhu","yunyi","123456");
//		User user2=new User("yamin@123.com","yamin","xue","123456778");
//		UserDao.SaveObject(user1);
//		UserDao.SaveObject(user2);
	}
	@Test
	public void GetTest(){
//		User user3=(User)UserDao.getObjectByEmail("zhuyu@123.com");
//		assertEquals(user3.getPwd(),"123456");
//		assertEquals(user3.getFirst_name(),"zhu");
//		assertEquals(user3.getLast_name(),"yunyi");
	}
	
	@Test
	public void GetAllObjectTest(){
		
		
	}

}
