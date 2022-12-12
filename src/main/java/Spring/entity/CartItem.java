/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Spring.entity;

/**
 *
 * @author ACER NITRO 5
 */
public class CartItem {

    private Product product;
    private int qty;
    private float total;

    public CartItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
        this.setTotal();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
        this.setTotal();
    }

    public float getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = this.product.getPrice() * this.qty;
    }
}
