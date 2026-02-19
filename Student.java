package com.myorganisation.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private  Long id = 101L;
    private String name = "Akram rana";
    private Course course;

    @Autowired
    private Course courseBean;

    public Student(){
        this.id = 101L;
        this.name = "Akram rana";
        this.course = courseBean;
    }
}
