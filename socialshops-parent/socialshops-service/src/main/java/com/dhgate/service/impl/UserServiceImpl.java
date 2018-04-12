package com.dhgate.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhgate.domain.User;
import com.dhgate.mapper.UserMapper;
import com.dhgate.service.UserService;

/**
 * @author gacl 使用@Service注解将UserServiceImpl类标注为一个service service的id是userService
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	/**
	 * 使用@Autowired注解标注userMapper变量， 当需要使用UserMapper时，Spring就会自动注入UserMapper
	 */
	@Autowired
	private UserMapper userMapper;// 注入dao

	public void addUser(User user) {
		userMapper.insert(user);
	}

	public User getUserById(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
	
}
