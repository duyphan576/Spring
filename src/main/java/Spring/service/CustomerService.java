/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Spring.Service;

import Spring.Entity.Customer;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER NITRO 5
 */
@Service
public interface CustomerService {
    
    public Customer registerCustomer(Customer customer);
    
    public boolean checkLogin(String username, String password);
}
