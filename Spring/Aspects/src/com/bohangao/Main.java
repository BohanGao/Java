package com.bohangao;

import com.bohangao.annotation.User;
import com.bohangao.config.Config;
import com.bohangao.xml.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //testAnnotation();
        testAnnotationNoConfig();
        //testXml();
    }

    private static void testAnnotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/bohangao/beans.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    private static void testAnnotationNoConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        User user = context.getBean("user", User.class);
        user.add();
    }

    private static void testXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/bohangao/beans2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}
