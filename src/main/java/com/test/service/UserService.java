package com.test.service;

import com.test.model.User;
import org.apache.ibatis.session.RowBounds;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * Created by win on 2018/9/9.
 */
public interface UserService {
    List<User> findUsers();
    void addUser(User user);
    int  findUserCount();
    List<User> FindAll(String fileName);
    List<User> findUsersByRowBounds(RowBounds rowBounds);

}
