package com.bohangao.service;

import com.bohangao.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserService {

    @Autowired
    @Qualifier(value = "userDao2")
    private IUserDao userDaoA;

    @Resource(name = "userDao1")
    private IUserDao userDaoB;

    @Value(value = "XYZ")
    private String name;

    public void process(){
        System.out.println("service is processing.");
        userDaoA.update();
        userDaoB.update();
        System.out.println(name);
    }
}
