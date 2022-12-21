/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.Repository;

import org.springframework.data.repository.CrudRepository;
import Spring.Entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ACER NITRO 5
 */
public interface ProductRepositpry extends CrudRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.ProductName LIKE %?1% OR p.strap.StrapName LIKE %?1%")
    Iterable<Product> findByNameOrStrap(@Param("keyword") String keyword);
}
