  package com.test.service.impl;

import com.test.mapper.UserMapper;
import com.test.model.User;
import com.test.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by win on 2018/9/9.
 */
@SuppressWarnings("unused")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findUsers() {
        return userMapper.findUsers();
    }

    @Override
    public void addUser(User user) {
         userMapper.addUser(user);
    }

    @Override
    public int findUserCount() {
        return userMapper.findUserCount();
    }
	@Override
	public List<User> FindAll(String fileName) {
		return userMapper.findUsers();
	}


}
