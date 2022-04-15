package com.joseloya.torrexfitness.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String customerFirstName;

    @Column
    private String customerLastName;

    @Column
    private double subTotal;

    @Column
    private double tax;

    @Column
    private double total;

    @Column
    private String placedOn;

    //One Order can have 1 or many OrderItems
    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItemSet;

    //One or Many Orders can belong to One Customer
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
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

    public String getPlacedOn() {
        return placedOn;
    }

    public void setPlacedOn(String placedOn) {
        this.placedOn = placedOn;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", subTotal=" + subTotal +
                ", tax=" + tax +
                ", total=" + total +
                ", placedOn='" + placedOn + '\'' +
                ", orderItemSet=" + orderItemSet +
                ", customer=" + customer +
                '}';
    }
}
