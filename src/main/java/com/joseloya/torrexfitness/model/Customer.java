package com.joseloya.torrexfitness.model;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customers")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @NotEmpty(message = "Please provide your first name")
    @Size(min = 1, max = 30)
    private String firstName;

    @Column
    @NotNull
    @NotEmpty(message = "Please provide your last name")
    @Size(min = 1, max = 30)
    private String lastName;

    @Column(unique = true)
    @NotNull
    @Email(message = "Please provide a valid Email")
    @NotEmpty(message = "Please provide an email")
    @Size(min = 3, max = 50)
    private String email;

    @Column
    @NotNull
    @Length(min = 5, message = "Your password must have at least 5 characters")
    @NotEmpty(message = "Please provide your password")
    private String password;

    //One Customer has One Cart
    @OneToOne(mappedBy = "customer")
    @PrimaryKeyJoinColumn
    private Cart cart;

    //One Customer can have 0, 1, or Many Orders
//    @OneToMany(mappedBy = "customer")
//    @OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
//    private Set<Order> orderSet;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

//    public Set<Order> getOrderSet() {
//        return orderSet;
//    }

//    public void setOrderSet(Set<Order> orderSet) {
//        this.orderSet = orderSet;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cart=" + cart +
                '}';
    }
}
