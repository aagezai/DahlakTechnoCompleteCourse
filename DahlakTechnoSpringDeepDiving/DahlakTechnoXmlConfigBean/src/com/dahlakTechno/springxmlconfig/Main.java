package com.dahlakTechno.springxmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String args[]){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld helloWorldObj = (HelloWorld) context.getBean("helloWorld");
        String message = helloWorldObj.getMessage();
        helloWorldObj.setMessage("Good Afternoon ");
        String message2 = helloWorldObj.getMessage();
        System.out.println(message2);

    }
}
