package com.myorganisation.beans;

import org.springframework.stereotype.Component;

@Component
public class Course {
    private  Long id;
    private  String name;


    public Course(){
        this.id =1L;
        this.name = "spring Framework";

    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
