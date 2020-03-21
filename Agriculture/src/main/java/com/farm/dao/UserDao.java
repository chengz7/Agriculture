package com.farm.dao;

import com.farm.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/10/31 19:44
 */
@Repository
public interface UserDao {

    User queryUser(User user);
}
