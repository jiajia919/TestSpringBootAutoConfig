package com.dhgate.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dhgate.domain.User;
import com.dhgate.service.UserService;

public class MyBatisTest {

	private UserService userServiceImpl;
	/**
     * 这个before方法在所有的测试方法之前执行，并且只执行一次
     * 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
     * 比如在before方法里面初始化ApplicationContext和userService
     */
    @Before
    public void before(){
        //使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext-mybatis.xml"});
        //从Spring容器中根据bean的id取出我们要使用的userService对象
        userServiceImpl = (UserService) ac.getBean("userServiceImpl");
    }
    
    @Test
    public void testAddUser(){
    	User user = new User();
    	user.setName("佳佳");
    	userServiceImpl.addUser(user);
    }
}
