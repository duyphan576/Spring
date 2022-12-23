/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Repository;

import org.springframework.data.repository.CrudRepository;
import Spring.Entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ACER NITRO 5
 */
public interface ProductRepositpry extends CrudRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.ProductName LIKE %?1% OR p.strap.StrapName LIKE %?1%")
    Iterable<Product> findByNameOrStrap(@Param("keyword") String keyword);
    
    @Query("SELECT o.product FROM OrderDetail o GROUP BY o.product ORDER BY SUM(o.Quantity) DESC")
    List<Product> sortBestSellingProduct();
}
