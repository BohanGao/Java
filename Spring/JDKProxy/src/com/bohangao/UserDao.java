package com.bohangao;

public class UserDao implements IUserDao{
    @Override
    public int add(int a, int b) {
        System.out.println("Executing add.");
        return a+b;
    }

    @Override
    public String update(String id) {
        System.out.println("Executing update.");
        return id;
    }
}
