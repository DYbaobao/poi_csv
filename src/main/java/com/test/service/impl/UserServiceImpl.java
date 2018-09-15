  package com.test.service.impl;

import com.test.mapper.UserMapper;
import com.test.model.User;
import com.test.service.UserService;
import com.test.utils.ExcelUtiles;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
	public List<User> FindAll(String fileName) {
		return userMapper.findUsers();
	}

	

}
