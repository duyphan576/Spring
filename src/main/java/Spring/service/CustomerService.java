/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Spring.service;

import Spring.entity.Customer;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER NITRO 5
 */
@Service
public interface CustomerService {
    
    public Customer registerCustomer(Customer customer);
}
