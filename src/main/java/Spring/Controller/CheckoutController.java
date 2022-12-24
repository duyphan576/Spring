/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Controller;

import Spring.Entity.CartItem;
import Spring.Entity.Customer;
import Spring.Entity.Order;
import Spring.Entity.OrderDetail;
import Spring.Service.CustomerServiceImpl;
import Spring.service.OrderDetailServiceImpl;
import Spring.service.OrderServiceImpl;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ACER NITRO 5
 */
@Controller
public class CheckoutController {

    @Autowired
    CustomerServiceImpl customerService;
    
    @Autowired
    OrderServiceImpl orderService;
    
    @Autowired
    OrderDetailServiceImpl orderDetailService; 

    @GetMapping("/checkout")
    public String showCheckut(Model m, HttpSession session) {
        if (session.getAttribute("user") != null) {
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            if (cart == null || cart.isEmpty()) {
                return "redirect:/";
            }
            Customer customer = customerService.getUserInfo(session.getAttribute("user").toString());
            m.addAttribute("user", customer);
            m.addAttribute("data", cart);
            m.addAttribute("total", CartController.getTotal(session));
            return "checkout1";
        }
        return "redirect:/register";
    }

    @PostMapping("/checkout")
    public String placeOrder(Model m, HttpSession session) {
        if (session.getAttribute("user") != null) {
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            if (cart == null || cart.isEmpty()) {
                return "redirect:/";
            }
            Customer customer = customerService.getUserInfo(session.getAttribute("user").toString());
            List<OrderDetail> orderDetailList = new ArrayList<>();
            cart.forEach(item -> {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct(item.getProduct());
                orderDetail.setPrice(item.getProduct().getPrice());
                orderDetail.setQuantity(item.getQty());
                orderDetailList.add(orderDetail);
            });
            Order order = new Order();
            order.setCustomerId(customer.getCustomerID());
            order.setDate(new Date(System.currentTimeMillis()));
            order.setTotalPrice(CartController.getTotal(session));
            order.setListOrderDetail(orderDetailList);
            orderService.saveOrder(order);
            return "checkout1";
        }
        return "redirect:/register";
    }
}
