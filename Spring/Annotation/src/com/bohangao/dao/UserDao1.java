package com.bohangao.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "userDao1")
public class UserDao1 implements IUserDao{
    @Override
    public void update() {
        System.out.println("a UserDao1 is updating");
    }
}
