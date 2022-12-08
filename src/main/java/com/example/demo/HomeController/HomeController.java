/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author duyph
 */
@Controller
public class HomeController {
    @GetMapping("/home")
    public String homepage(){
        return "index";
    }
    
    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
