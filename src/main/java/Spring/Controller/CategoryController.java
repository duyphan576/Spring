/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Controller;

import Spring.Entity.Customer;
import Spring.Entity.Product;
import Spring.Entity.Strap;
import Spring.Service.CustomerServiceImpl;
import Spring.Service.ProductServiceImpl;
import Spring.Service.StrapServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author duyph
 */
@Controller
public class CategoryController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private StrapServiceImpl strapService;
    
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/")
    public String getProduct(Model m, @RequestParam(name = "keyword", required = false) String keyword, HttpSession session) {
        Iterable<Product> list = productService.findAll(keyword);
        Iterable<Strap> straps = strapService.findAll();
        m.addAttribute("data", list);
        m.addAttribute("straps", straps);
        if(session.getAttribute("user") != null) {
            Customer customer = customerService.getUserInfo(session.getAttribute("user").toString());
            m.addAttribute("user", customer);
        }
        return "category";
    }

    @GetMapping("/category/{strapId}")
    public String getProductByStrap(Model m, @PathVariable("strapId") int strapId, HttpSession session) {
        Iterable<Product> list = productService.getByStrapId(strapId);
        Iterable<Strap> straps = strapService.findAll();
        m.addAttribute("data", list);
        m.addAttribute("straps", straps);
        if(session.getAttribute("user") != null) {
            Customer customer = customerService.getUserInfo(session.getAttribute("user").toString());
            m.addAttribute("user", customer);
        }
        return "category";
    }

    @GetMapping("/best-selling")
    public String sortBProduct(Model m, HttpSession session) {
        Iterable<Product> list = productService.sortBestSellingProduct();
        Iterable<Strap> straps = strapService.findAll();
        m.addAttribute("data", list);
        m.addAttribute("straps", straps);
        if(session.getAttribute("user") != null) {
            Customer customer = customerService.getUserInfo(session.getAttribute("user").toString());
            m.addAttribute("user", customer);
        }
        return "category";
    }
}
