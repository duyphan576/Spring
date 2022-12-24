/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Spring.repository;

import Spring.Entity.Order;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ACER NITRO 5
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    
    public List<Order> findByCustomerId(int userId);
}
