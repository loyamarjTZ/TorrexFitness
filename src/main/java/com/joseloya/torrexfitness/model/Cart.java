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
    private Long id;

    //A Cart can have 0, 1, or many CartItems
//    (mappedBy = "cart")
    @OneToMany
    private Set<CartItem> cartItemSet;

    //One Cart belongs to One Customer
    @OneToOne
    @MapsId
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Cart(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CartItem> getCartItemSet() {
        return cartItemSet;
    }

    public void setCartItemSet(Set<CartItem> cartItemSet) {
        this.cartItemSet = cartItemSet;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartItemSet=" + cartItemSet +
                ", customer=" + customer +
                '}';
    }
}