/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Spring.Service;

import Spring.Entity.Product;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER NITRO 5
 */
@Service
public interface ProductService {

    Iterable<Product> findAll(String keyword);
    
    Product getProductByID(int id);

    List<Product> getByStrapId(int strapId);
}
