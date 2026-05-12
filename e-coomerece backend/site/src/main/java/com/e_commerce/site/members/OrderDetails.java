package com.e_commerce.site.members;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orderdetails")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customername;
    private String phone;
    private String town;
    private String city;
    private String state;
    private String pincode;
    private String status = "Preparing";
    private String date = LocalDate.now().plusDays(3).toString();
    private int quantity = 1;

    @ManyToOne
    @JoinColumn(name = "activeorders_id")
    private OrderedCustomer orderedCustomer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;

    public OrderDetails() {
    }

    public OrderDetails(Long id, String customername, String phone, String town, String city, String state, String pincode, String status, OrderedCustomer activeOrders, Products products) {
        this.id = id;
        this.customername = customername;
        this.phone = phone;
        this.town = town;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.status = status;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderedCustomer getOrderedCustomer() {
        return orderedCustomer;
    }

    public void setOrderedCustomer(OrderedCustomer orderedCustomer) {
        this.orderedCustomer = orderedCustomer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        quantity = quantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
