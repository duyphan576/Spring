/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @Column(name = "Username")
    @NotBlank(message = "Username cannot be empty.")
    private String username;

    @Column
    @NotBlank(message = "Password cannot be empty.")
    private String Password;

    @Column
    @NotBlank(message = "Full name cannot be empty.")
    private String FullName;

    @Column
    @NotBlank(message = "Address cannot be empty.")
    private String Address;
}
