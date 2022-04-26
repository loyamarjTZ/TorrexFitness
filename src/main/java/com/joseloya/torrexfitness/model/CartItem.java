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

    public CartItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(id, cartItem.id) && Objects.equals(product, cartItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product);
    }
}
