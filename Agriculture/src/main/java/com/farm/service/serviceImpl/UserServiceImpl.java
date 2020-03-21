package com.farm.service.serviceImpl;

import com.farm.dao.UserDao;
import com.farm.entity.User;
import com.farm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/10/31 20:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(User user) {
        return userDao.queryUser(user);
    }
}
