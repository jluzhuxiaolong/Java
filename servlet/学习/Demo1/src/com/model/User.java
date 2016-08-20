package com.model;

/**
 * Created by Administrator on 2016/8/20.
 */
public class User {

    private String name;

    private  String sex;

    private int age;

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getSex(){
        return  this.sex;
    }

    public  void setSex(String sex){
        this.sex = sex;
    }

    public  int getAge(){
        return  this.age;
    }

    public  void setAge(int age){
        this.age = age;
    }
}
