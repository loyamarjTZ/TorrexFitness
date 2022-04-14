package com.joseloya.torrexfitness.model;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    @Size(min = 1, max = 30)
    private String name;

    @Column
    @NotNull
    @Size(min = 1, max = 500)
    private String description;

    @Column
    @NotNull
    @Range(min = 0L, max = 10000)
    private double price;

//    TODO - double check this statement with someone
//    "One Product can be Many CartItems"
    @OneToMany(mappedBy = "product")
    private Set<CartItem> cartItems;

    public Product() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
