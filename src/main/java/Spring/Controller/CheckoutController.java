/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Controller;

import Spring.Entity.CartItem;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ACER NITRO 5
 */
@Controller
public class CheckoutController {
    
    @GetMapping("/checkout")
    public String showCheckut(Model m, HttpSession session ) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        m.addAttribute("data", cart);
        m.addAttribute("total", CartController.getTotal(session));
        return "checkout1";
    }
}
