package com.employee;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestQuestion {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        
        Question question = (Question) beanFactory.getBean("ques");
    
        System.out.println(question);
    
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Question2 question2 = (Question2) applicationContext.getBean("ques2");
        System.out.println(question2);
    }
}
