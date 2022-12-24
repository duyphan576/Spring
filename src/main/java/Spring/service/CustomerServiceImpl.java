/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Service;

import Spring.Entity.Customer;
import Spring.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER NITRO 5
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setUsername(customer.getUsername());
        newCustomer.setPassword(customer.getPassword());
        newCustomer.setFullName(customer.getFullName());
        newCustomer.setAddress(customer.getAddress());

        return customerRepository.save(newCustomer);
    }

    @Override
    public boolean checkLogin(String username, String password) {
        Customer c = customerRepository.findByUsername(username);
        if (c != null && c.getPassword().equals(password)) {

            return true;
        }
        return false;
    }

    @Override
    public Customer getUserInfo(String username) {
        try {
            Customer c = customerRepository.findByUsername(username);
            c.setPassword(null);
            return c;
        } catch (Exception e) {
        }
        return null;
    }

}
