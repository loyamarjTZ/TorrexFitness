package com.joseloya.torrexfitness.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private int userId;

    @Column
    private double subTotal;

    @Column
    private double tax;

    @Column
    private double total;

    public Cart(){

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

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id && userId == cart.userId && Double.compare(cart.subTotal, subTotal) == 0 && Double.compare(cart.tax, tax) == 0 && Double.compare(cart.total, total) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, subTotal, tax, total);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", subTotal=" + subTotal +
                ", tax=" + tax +
                ", total=" + total +
                '}';
    }
}