package com.example.demo;

import org.springframework.stereotype.Component;

@Component 
public class FirstService {
    private String myVar;

    public FirstService(String myVar) {
        this.myVar = myVar;
    }    
    public String hello(){
        return "Hello => "+myVar;}

    
}
