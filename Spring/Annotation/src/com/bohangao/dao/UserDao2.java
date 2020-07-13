package com.bohangao.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "userDao2")
public class UserDao2 implements IUserDao{
    @Override
    public void update() {
        System.out.println(("a UserDao2 is updating"));
    }
}
