package com.farm.controller.UserAdmin;

import com.farm.entity.User;
import com.farm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2018/10/31 14:55
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody User userInfo){
        Map<String, Object> modelMap = new HashMap<>();
        if (userInfo != null&&userInfo.getUsername()!=null&&userInfo.getPassword()!=null) {
            User result = userService.getUser(userInfo);
            if (result != null) {
                modelMap.put("success", true);
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "用户名或密码错误！");
            }
        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "登陆信息不能为空！");
        }
        return modelMap;
    }

}
