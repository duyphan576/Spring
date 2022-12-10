/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

/**
 *
 * @author jukut
 */
@Data
@Entity
@Table(name = "Strap")
public class Strap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StrapID;

    @Column
    private String StrapName;

    @OneToMany(mappedBy="strap")
    private List<Product> products;
}
