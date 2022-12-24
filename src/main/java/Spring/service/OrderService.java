/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Spring.service;

import Spring.Entity.Order;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER NITRO 5
 */
@Service
public interface OrderService {

    public Order saveOrder(Order order);

    public List<Order> getOrderByUserId(int userId);
}
