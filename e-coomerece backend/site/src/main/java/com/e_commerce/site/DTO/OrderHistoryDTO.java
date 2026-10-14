package com.e_commerce.site.DTO;

import com.e_commerce.site.members.Products;

public class OrderHistoryDTO {
    
    private String status;
    private Long customerUser;
    private String customerType;
    private String date;
    private Products product;

    public OrderHistoryDTO(String status, Long customerUser, String customerType, String date, Products product) {
        this.status = status;
        this.customerUser = customerUser;
        this.customerType = customerType;
        this.date = date;
        this.product = product;
    }

    public OrderHistoryDTO() {}

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