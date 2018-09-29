package com.test.mapper;

import com.github.pagehelper.Page;
import com.test.model.User;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by win on 2018/9/9.
 */
public interface UserMapper {
    List<User> findUsers();
    int  findUserCount();
    void addUser(User user);
    Page<User> findUsersByRowBounds(RowBounds rowBounds);
}
