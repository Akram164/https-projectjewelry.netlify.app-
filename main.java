package com.myorganisation.config;

import com.myorganisation.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[]args){
        ApplicationContext context = new AnnotationConfigApplicationContext(com.myorganisation.config.AppConfig.class);

        Student student = context.getBean(Student.class);
        System.out.println(student);
    }

}
