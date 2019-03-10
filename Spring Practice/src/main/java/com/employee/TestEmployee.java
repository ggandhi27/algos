package com.employee;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestEmployee {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        Employee employee = (Employee) beanFactory.getBean("employeeBean");
        System.out.println(employee);
        Employee employee1 = (Employee) beanFactory.getBean("employee2");
        System.out.println(employee1);
        Employee employee2 = (Employee) beanFactory.getBean("employee3");
        System.out.println(employee2);
        
        Employee employee3 = (Employee) beanFactory.getBean("employee4");
        System.out.println(employee3);
    }
}
