/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 *
 * @author jukut
 */
@Data
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CustomerID;

    @Column
    private String Account;
    
    @Column
    private String Password;

    @Column
    private String FullName;

    @Column
    private String Address;
    
    public int getCustomerID() {
        return this.CustomerID;
    }

    @Override
    public String toString() {
        return this.CustomerID + " - " + this.FullName;
    }
}
