package com.joseloya.torrexfitness.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //One CartItem corresponds to One Product
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

//    @Column
//    private Integer quantity;

    //0, 1, or Many CartItems can belong to 1 Cart
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "cart_id", nullable = false)
//    private Cart cart;

    public CartItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }

//    public Cart getCart() {
//        return cart;
//    }
//
//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
//                ", quantity=" + quantity +
//                ", cart=" + cart +
                ", product=" + product +
                '}';
    }
}
