package com.dhgate.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dhgate.domain.User;
import com.dhgate.po.Test1;
import com.dhgate.service.MongoTest;
import com.dhgate.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml","classpath*:applicationContext-*.xml"})
public class MyBatisTest {
	@Resource(name = "userServiceImpl")
	private UserService userServiceImpl;

	@Test
    public void testAddUser(){
    	User user = new User();
    	user.setName("佳佳");
    	User userById = userServiceImpl.getUserById(7);
    	System.out.println(userById);
    }
	
}
