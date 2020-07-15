package com.bohangao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Class[] interfaces = {IUserDao.class};
        IUserDao user = new UserDao();
        user = (IUserDao) Proxy.newProxyInstance(Main.class.getClassLoader(), interfaces, new UserDaoProxy(user));
        int result = user.add(1, 2);
        System.out.println(result);
    }
}

class UserDaoProxy implements InvocationHandler{
    private Object obj;

    public UserDaoProxy(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Start to invoke "+method.getName()+" with parameters "+ Arrays.toString(args));

        Object result = method.invoke(obj, args);

        System.out.println("Done invoking "+method.getName()+" with parameters "+ Arrays.toString(args));
        return result;
    }
}
