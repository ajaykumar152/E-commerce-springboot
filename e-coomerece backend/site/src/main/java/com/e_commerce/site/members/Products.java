package com.e_commerce.site.members;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Products {

    @Id
    private String id;

    private String productName;
    private Double price = 0.0;
    private String productLink;
    private String productType;
    private String productDescription;

    @OneToMany(mappedBy = "products")
    @JsonIgnore
    private List<CartItems> cartItems;

    @OneToMany(mappedBy = "products")
    @JsonIgnore
    private List<OrderDetails> orderDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Products() {
    }

    public Products(Long id, String productName, Double price, String productLink, String productType, String productDescription) {
        this.productName = productName;
        this.price = price;
        this.productLink = productLink;
        this.productType = productType;
        this.productDescription = productDescription;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public List<CartItems> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItems> cartItems) {
        this.cartItems = cartItems;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
