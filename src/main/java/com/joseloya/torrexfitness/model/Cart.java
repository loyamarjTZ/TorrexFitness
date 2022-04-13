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
    private int id;

    @Column
    @NotNull
    private int userId;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItemList;

    public Cart(){
    }

    public Cart(int id, int userId, Set<CartItem> cartItemList) {
        this.id = id;
        this.userId = userId;
        this.cartItemList = cartItemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(Set<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id && userId == cart.userId && Objects.equals(cartItemList, cart.cartItemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, cartItemList);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", cartItemList=" + cartItemList +
                '}';
    }
}