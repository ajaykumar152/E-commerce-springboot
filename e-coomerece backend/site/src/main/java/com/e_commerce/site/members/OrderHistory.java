package com.e_commerce.site.members;
import com.e_commerce.site.members.Products;
import jakarta.persistence.*;

@Entity
@Table(name="OrderHistory")
public class OrderHistory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String status;
    private Long customerUser;
    private String customerType;
    private String date;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Products product;

    public Long getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomerUser(Long customerUser) {
        this.customerUser = customerUser;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public String getStatus() { return status; }

    public Long getCustomerUser() { return customerUser; }

    public String getCustomerType() { return customerType; }

    public String getDate() { return date; }

    public Products getProduct() { return product; }
}