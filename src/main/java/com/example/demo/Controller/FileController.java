package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class FileController {
    @RequestMapping("/instructions")
    public String index(){
        return "instructions";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";

    }
    @RequestMapping("/text")
    public String text(){
        return "text";
    }

    @RequestMapping("/home")
    public String home(){
        System.out.println("aa");

        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/regis")
    public String regis(){return "regis";}

    @RequestMapping("/regisUser")
    public String registerUser(){
        return "registerUser";
    }
}

