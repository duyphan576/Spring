/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Controller;

import Spring.Entity.CartItem;
import Spring.Entity.Product;
import Spring.Service.ProductServiceImpl;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER NITRO 5
 */
@Controller
public class CartController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/cart")
    public String showCart(Model m, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        m.addAttribute("data", cart);
        m.addAttribute("total", getTotal(session));
        return "basket";
    }

    @GetMapping("/cart/add/{productId}")
    public String addToCart(@PathVariable("productId") int productId, HttpSession session) {
        Product product = productService.getProductByID(productId);
        if (session.getAttribute("cart") == null) {
            List<CartItem> cart = new ArrayList<>();
            cart.add(new CartItem(product, 1));
            session.setAttribute("cart", cart);
        } else {
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            int index = -1;
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getProduct().getProductID() == product.getProductID()) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                int quantity = cart.get(index).getQty();
                cart.get(index).setQty(quantity + 1);
            } else {
                cart.add(new CartItem(product, 1));
            }
            session.setAttribute("cart", cart);
        }
        return "redirect:/";
    }

    @GetMapping("/cart/remove/{productId}")
    public String removeItem(@PathVariable("productId") int productId, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getProductID() == productId) {
                cart.remove(i);
                break;
            }
        }
        return "redirect:/cart";
    }

    @PostMapping("/cart")
    public String updateCart(@RequestParam int productId, @RequestParam int qty, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getProductID() == productId) {
                cart.get(i).setQty(qty);
                break;
            }
        }
        return "redirect:/cart";
    }

    public static int getAmount(HttpSession session) {
        int amount = 0;

        try {
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            for (int i = 0; i < cart.size(); i++) {
                amount += cart.get(i).getQty();
            }
        } catch (Exception e) {
            return amount;
        }

        return amount;
    }

    public static float getTotal(HttpSession session) {
        float total = 0;

        try {
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            for (int i = 0; i < cart.size(); i++) {
                CartItem item = cart.get(i);
                total += (item.getProduct().getPrice() * item.getQty());
            }
        } catch (Exception e) {
            return total;
        }

        return total;
    }
}
