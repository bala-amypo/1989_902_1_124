package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class basic {
    @GetMapping("/home")
    public String sample(){
        return "hello world";
    }
}