package com.farm.service.serviceImpl;

import com.farm.entity.User;
import com.farm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/10/31 20:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123");
        assertEquals(user.getUsername(),userService.getUser(user).getUsername());
    }
}