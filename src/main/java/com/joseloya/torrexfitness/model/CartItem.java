package com.joseloya.torrexfitness.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long productId;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name="cartId", nullable=false)
    private Cart cart;

    public CartItem() {
    }

    public CartItem(long id, long productId, int quantity, Cart cart) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return id == cartItem.id && productId == cartItem.productId && quantity == cartItem.quantity && Objects.equals(cart, cartItem.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, quantity, cart);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", cart=" + cart +
                '}';
    }
}
