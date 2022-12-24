/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Controller;

import Spring.Entity.Customer;
import Spring.Service.CustomerServiceImpl;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @PostMapping("/login")
    public String checkLogin(ModelMap model, @RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        if (customerService.checkLogin(username, password)) {
            session.setAttribute("user", username);
            return "redirect:/";
        }
        return "redirect:/register";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}
