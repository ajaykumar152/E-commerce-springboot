package com.e_commerce.site.DTO;

import java.util.List;

public class OrderedProductDTO {

    private Long id;

    private String customername;
    private String phone;
    private String town;
    private String city;
    private String state;
    private String pincode;
    private String productId;
    private int quantity;


    public OrderedProductDTO(Long id, String customername, String phone, String town, String city, String state, String pincode, String productId) {
        this.id = id;
        this.customername = customername;
        this.phone = phone;
        this.town = town;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.productId = productId;
    }

    public OrderedProductDTO() {
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
