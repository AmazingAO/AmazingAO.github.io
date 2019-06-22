package com.main.controller;

public class HelloWord {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  void hello(){
        System.out.println("hello:"+name);
    }
}
