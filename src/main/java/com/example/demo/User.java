package com.example.demo;

import lombok.Data;

@Data
public class User {

    @AttributeRequired(value = 1)
    private String name;

    @AttributeRequired(value = 1)
    private Integer age;

    private Integer sex;

    public User(){}

    public User(String name, Integer age, Integer sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

}
