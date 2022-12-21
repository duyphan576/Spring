/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Spring.repository;

import Spring.entity.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ACER NITRO 5
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    public Customer findByUsername(String username);
}
