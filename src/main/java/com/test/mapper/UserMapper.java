package com.test.mapper;

import com.test.model.User;

import java.util.List;

/**
 * Created by win on 2018/9/9.
 */
public interface UserMapper {
    List<User> findUsers();
    void addUser(User user);
}
