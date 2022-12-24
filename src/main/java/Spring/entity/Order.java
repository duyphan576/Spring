/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Entity;

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

    @Column(name="CustomerID")
    private int customerId;

    @Column
    private float TotalPrice;

    @Column
    private Date Date;

    @OneToMany(mappedBy = "orderID", cascade = CascadeType.ALL)
    private List<OrderDetail> listOrderDetail;
}
