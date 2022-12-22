/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Controller;

import Spring.Entity.Customer;
import Spring.Service.CustomerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ACER NITRO 5
 */
@Controller
public class RegisterController {
    
    @Autowired
    private CustomerServiceImpl customerService;
    
    @GetMapping("/register")
    public String showRegister(Model m) {
        Customer customer = new Customer();
        m.addAttribute("customer", customer);
        return "register";
    }
    
    @PostMapping("/register")
    public String saveRegister(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "register";
        }
        customerService.registerCustomer(customer);
        return "redirect:/";
    }
}
