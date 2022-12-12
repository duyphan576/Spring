/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Controller;

import Spring.entity.Product;
import Spring.entity.Strap;
import Spring.service.ProductServiceImpl;
import Spring.service.StrapServiceImpl;
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

    @GetMapping("/")
    public String homepage(Model m, @RequestParam(name="keyword", required=false) String keyword) {
        Iterable<Product> list = productService.findAll(keyword);
        Iterable<Strap> straps = strapService.findAll();
        m.addAttribute("data", list);
        m.addAttribute("straps", straps);
        return "category";
    }

    @GetMapping("/category/{strapId}")
    public String getProductByStrap(Model m, @PathVariable("strapId") int strapId) {
        Iterable<Product> list = productService.getByStrapId(strapId);
        Iterable<Strap> straps = strapService.findAll();
        m.addAttribute("data", list);
        m.addAttribute("straps", straps);
        return "category";
    }
}
