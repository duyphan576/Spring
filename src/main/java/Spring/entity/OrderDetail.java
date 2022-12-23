/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 *
 * @author jukut
 */
@Data
@Entity
@Table(name = "Orderdetail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderDetailID;

    @Column
    private int Quantity;

    @Column
    private float Price;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order orderID;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ProductID")
    private Product product;
}
