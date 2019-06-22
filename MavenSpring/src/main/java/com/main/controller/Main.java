package com.main.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        HelloWord helloWord = (HelloWord) context.getBean("helloWord");
        helloWord.hello();
    }
}
