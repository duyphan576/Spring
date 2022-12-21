/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Service;

import Spring.Entity.Product;
import Spring.Repository.ProductRepositpry;
import Spring.Repository.StrapRepositpry;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER NITRO 5
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepositpry productRepositpry;

    @Autowired
    private StrapRepositpry strapRepository;

    @Override
    public Iterable<Product> findAll(String keyword) {
        if (keyword != null) {
            System.out.println(keyword);
            return productRepositpry.findByNameOrStrap(keyword);
        }
        return productRepositpry.findAll();
    }

    @Override
    public Product getProductByID(int id) {
        return productRepositpry.findById(id).get();
    }

    @Override
    public List<Product> getByStrapId(int strapId) {
        return strapRepository.findById(strapId).get().getProducts();
    }
}
