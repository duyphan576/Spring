/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.service;

import Spring.entity.Customer;
import Spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER NITRO 5
 */
@Service
public class CustomerServiceImple implements CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(Customer customer) {
        if(customerRepository.findByUsername(customer.getUsername()) != null) {
            
        }
        
        Customer newCustomer = new Customer();
        newCustomer.setUsername(customer.getUsername());
        newCustomer.setPassword(customer.getPassword());
        newCustomer.setFullName(customer.getFullName());
        newCustomer.setAddress(customer.getAddress());
        
        return customerRepository.save(newCustomer);
    }
    
}