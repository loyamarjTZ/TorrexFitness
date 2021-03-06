package com.joseloya.torrexfitness.model;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    @Length(min = 1, message = "Name cannot be left blank")
    private String name;

    @Column
    @NotNull
    @Size(min = 1, max = 500, message = "Description cannot be left blank")
    private String description;

    @Column
    @NotNull
    @Range(min = 1, max = 10000, message = "Price must be greater than or equal to 1")
    private Double price;

    @Column
    @Min(value = 1, message = "Quantity has to be non-negative number")
    private Integer quantity;

    //One Product corresponds to One CartItem
    @OneToOne(mappedBy = "product")
    @PrimaryKeyJoinColumn
    private CartItem cartItem;

    public Product() {
        this.quantity = 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", cartItem=" + cartItem +
                '}';
    }
}
