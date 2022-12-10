/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.Strap;
import com.example.demo.repository.ProductRepositpry;
import com.example.demo.repository.StrapRepositpry;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER NITRO 5
 */
@Service
public class StrapServiceImpl implements StrapService{
    
    @Autowired
    private StrapRepositpry strapRepository;

    @Override
    public Iterable<Strap> findAll() {
        return strapRepository.findAll();
    }

    @Override
    public List<Strap> search(String term) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
