/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 *
 * @author duyph
 */
@Data
@Entity
@Table(name = "Product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductID;

    @Column
    private String ProductName;

    @Column
    private float Price;

    @Column
    private String Image;

    @Column
    private int Quantity;

//    @Column
//    private String ProductDetail;

    @ManyToOne
    @JoinColumn(name = "StrapID")
    private Strap strap;

    @ManyToOne
    @JoinColumn(name = "BrandID")
    private Brand brand;
}
