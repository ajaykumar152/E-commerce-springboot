package com.e_commerce.site.members;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private String customerUsername;

    private String email;
    private Long phone;
    private String password;
    private String role = "user";

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @OneToOne(mappedBy = "customer")
    private OrderedCustomer orderedCustomer;

    public Customer() {
    }

    public Customer(String email, Long phone, String password) {
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
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

    public OrderedCustomer getOrderedCustomer() {
        return orderedCustomer;
    }

    public void setOrderedCustomer(OrderedCustomer orderedCustomer) {
        this.orderedCustomer = orderedCustomer;
    }
}
