package com.joseloya.torrexfitness.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItemList;

    public Cart(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(Set<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartItemList=" + cartItemList +
                '}';
    }
}