package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
imo
@RestController
public class basic {
    @GetMapping("/home")
    public String sample(){
        return "hello world";
    }
}