/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepositpry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author duyph
 */
@Controller
public class CategoryController {
    
    @Autowired
    private ProductRepositpry productRepositpry;
    
    @GetMapping("/")
    public String homepage(Model m){
        Iterable<Product> list = productRepositpry.findAll();
        m.addAttribute("data", list);
        return "category";
    }
}
