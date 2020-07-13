package com.bohangao;

import com.bohangao.config.UserServiceSpringConfig;
import com.bohangao.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //testService1();
        testService2();
    }

    private static void testService1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService service = context.getBean("userService", UserService.class);
        service.process();
    }

    private static void testService2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(UserServiceSpringConfig.class);
        UserService service = context.getBean("userService", UserService.class);
        service.process();
    }
}
