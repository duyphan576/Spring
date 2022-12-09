/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import java.sql.Date;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

/**
 *
 * @author jukut
 */
@Data
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderID;

    @Column
    private int UserID;

    @Column
    private int CustomerID;

    @Column
    private int TotalQuantity;

    @Column
    private float TotalPrice;

    @Column
    private Date Date;

    @Column
    private int Status;

    @OneToMany(mappedBy = "orderID")
    private List<OrderDetail> listOrderDetail;
}
